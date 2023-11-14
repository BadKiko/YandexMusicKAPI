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
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import retrofit2.Retrofit
import java.time.LocalTime

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

        session?.let {
            val firstTrack = tracksQueue?.first()?.track?.id?.toIntOrNull()

            val requestRadioTracksQueue = RequestRadioTracksQueue(
                if (firstTrack == null) {
                    listOf()
                } else {
                    listOf(firstTrack)
                }
            )

            return when (
                /* Получает следующие треки для использования нужно пробросить 1 трек что был в очереди
             ref: https://github.com/MarshalX/yandex-music-api/issues/589*/

                val result = RadioUseCase(radioRepository).getRadioTracksQueue(
                    it.radioSessionId, requestRadioTracksQueue
                )
            ) {
                is ApiResponse.Failure -> RadioQueueYandexState.Error(result.message())
                is ApiResponse.Success -> {
                    tracksQueue = result.data.result.sequence


                    tracksQueue?.let { tracks ->
                        radioRepository.notifyStartRadioSession(
                            it.radioSessionId,
                            RequestNotifyRadio(
                                it.batchId,
                                EventEntity.generateEvent(
                                    tracks.first().track.id.toInt(),
                                    RadioEvent.START_RADIO
                                )
                            )
                        )
                    }

                    RadioQueueYandexState.Success(result.data.result)
                }
            }
        }

        fun getCurrentPlayingTrack(): TracksQueueEntity? {
            tracksQueue?.let { tracks ->

                val nowPlayingIndex = tracks.indexOfFirst { it == nowPlayingTrack }
                nowPlayingTrack = tracks.getOrElse(nowPlayingIndex + 1) {
                    tracks.last()
                }

                session?.let {
                    radioRepository.notifySkipTrackFromRadioSession(
                        it.radioSessionId,
                        RequestNotifyRadio(
                            it.batchId,
                            EventEntity.generateEvent(
                                nowPlayingTrack!!.track.id.toInt(),
                                RadioEvent.START_RADIO
                            )
                        )
                    )
                }
            }
            return nowPlayingTrack
        }
        /*
                fun nextTrack() {
                    radioRepository.notifySkipTrackFromRadioSession()

                }*/
    }
}