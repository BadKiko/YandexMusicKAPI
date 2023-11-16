package com.kiko.yandexmusicapi.data.radio

import com.kiko.yandexmusicapi.data.common.RadioQueueYandexState
import com.kiko.yandexmusicapi.data.common.RadioSessionYandexState
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.EventEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RadioEvent
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNotifyRadio
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestRadioTracksQueue
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.TracksQueueEntity
import com.kiko.yandexmusicapi.di.radio.RadioModule
import com.kiko.yandexmusicapi.domain.radio.usecase.RadioUseCase
import com.kiko.yandexmusicapi.utils.toLocalTime
import com.kiko.yandexmusicapi.utils.toYandexType
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import retrofit2.Retrofit
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit

/**
 * Класс предоставляющий работу с радио
 */
class YandexMusicRadio(private val retrofit: Retrofit) {
    private val radioRepository =
        RadioModule.provideRadioRepository(RadioModule.provideRadioApi(retrofit))

    var session: RadioSessionEntity? = null

    var tracksQueue: List<TracksQueueEntity>? = null
        private set

    var nowPlayingTrack: TracksQueueEntity? = null
        private set

    var trackPlayingTime: LocalTime = LocalTime.now()
        private set

    /**
     * Создание радио сессии с кастом параметрами
     *
     * @param requestNewRadioSession - запрос кастомной сессии
     * @return сессия и треки
     */
    suspend fun getCustomRadioSession(requestNewRadioSession: RequestNewRadioSession): RadioSessionYandexState {
        return when (val result =
            RadioUseCase(radioRepository).getNewUserRadioSession(requestNewRadioSession)) {
            is ApiResponse.Failure -> RadioSessionYandexState.Error(result.message())
            is ApiResponse.Success -> RadioSessionYandexState.Success(result.data.result)
        }
    }

    /**
     * Создание радио сессии onmywave (моя волна)
     *
     * @return сессия и треки
     */
    suspend fun getMyWaveRadioSession(): RadioSessionYandexState {
        val requestNewRadioSession = RequestNewRadioSession(
            seeds = listOf("user:onyourwave"),
            includeTracksInResponse = false
        )

        return when (
            val result =
                RadioUseCase(radioRepository).getNewUserRadioSession(requestNewRadioSession)
        ) {
            is ApiResponse.Failure -> RadioSessionYandexState.Error(result.message())
            is ApiResponse.Success -> {
                session = result.data.result

                RadioSessionYandexState.Success(result.data.result)
            }
        }
    }

    /**
     * Получает следующую последовательность треков из радио
     *
     * @return сессия и треки
     */
    @Throws
    suspend fun getTracksQueue(): RadioQueueYandexState {
        if (session == null)
            throw Exception("Вам необходимо сначала получить радио сессию через getMyWaveRadioSession или getCustomRadioSession")

        val firstTrack = tracksQueue?.first()?.track?.id?.toIntOrNull()

        // Генерируем запрос для получения очереди треков
        val requestRadioTracksQueue = RequestRadioTracksQueue(
            if (firstTrack == null) {
                listOf()
            } else {
                listOf(firstTrack)
            }
        )


        return when (
            /* Получает следующие треки для использования
         ref: https://github.com/MarshalX/yandex-music-api/issues/589*/

            val result = RadioUseCase(radioRepository).getRadioTracksQueue(
                session!!.radioSessionId, requestRadioTracksQueue
            )
        ) {
            is ApiResponse.Failure -> RadioQueueYandexState.Error(result.message())
            is ApiResponse.Success -> {
                tracksQueue = result.data.result.sequence

                // Записываем текущий трек для прослушивания
                nowPlayingTrack = tracksQueue!!.first()

                // Уведомляем Yandex Music что радио начило работать
                val radioNotifyEvent = RequestNotifyRadio(
                    session!!.batchId,
                    EventEntity.generateEvent(
                        tracksQueue!!.first().track.id.toInt(),
                        RadioEvent.START_RADIO
                    )
                )

                radioRepository.notifyStartRadioSession(
                    session!!.radioSessionId,
                    radioNotifyEvent
                )

                RadioQueueYandexState.Success(result.data.result)
            }
        }
    }

    /**
     * Получает текущий играющий трек
     */
    fun getCurrentPlayingTrack(): TracksQueueEntity? {
        if (session == null)
            throw Exception("Вам необходимо сначала получить радио сессию через getMyWaveRadioSession или getCustomRadioSession")

        // Считаем что если получили запрос на получение трека то его будут слушать
        trackPlayingTime = LocalTime.now()

        nowPlayingTrack?.let { playingTrack ->
            // Уведомляем Yandex Music что начался трек
            radioRepository.notifyStartTrackFromRadioSession(
                session!!.radioSessionId,
                RequestNotifyRadio(
                    session!!.batchId,
                    EventEntity.generateEvent(
                        playingTrack.track.id.toInt(),
                        RadioEvent.START_TRACK
                    )
                )
            )
        }

        return nowPlayingTrack
    }

    fun nextTrack() {
        if (session == null)
            throw Exception("Вам необходимо сначала получить радио сессию через getMyWaveRadioSession или getCustomRadioSession")

        // Уведомляем Яндекс Музыку что мы пропускаем трек
        nowPlayingTrack?.let { playingTrack ->
            radioRepository.notifySkipTrackFromRadioSession(
                session!!.radioSessionId,
                RequestNotifyRadio(
                    session!!.batchId,
                    EventEntity.generateEvent(
                        playingTrack.track.id.toInt(),
                        Duration.between(LocalTime.now(), trackPlayingTime)
                            .toLocalTime().toSecondOfDay().toString(),
                        RadioEvent.SKIP_TRACK
                    )
                )
            )


            // TODO(Сделать потом end track notify)

            // Получаем следующий трек
            val nextTrackIndex = tracksQueue!!.indexOf(playingTrack)+1
            if (nextTrackIndex == tracksQueue!!.lastIndex) {
                //TODO(Сделать обновление секвенции треков)
            } else {
                nowPlayingTrack = tracksQueue!![nextTrackIndex]
            }
        }
    }
}