package com.kiko.yandexmusicapi.data.radio

import com.kiko.yandexmusicapi.data.liked.state.LikedPlaylistsYandexState
import com.kiko.yandexmusicapi.data.common.LikedTracksYandexState
import com.kiko.yandexmusicapi.data.common.RadioSessionYandexState
import com.kiko.yandexmusicapi.data.liked.state.LikedAlbumYandexState
import com.kiko.yandexmusicapi.data.liked.state.LikedArtistsYandexState
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.di.likes.LikedModule
import com.kiko.yandexmusicapi.di.radio.RadioModule
import com.kiko.yandexmusicapi.domain.likes.usecase.LikedUseCase
import com.kiko.yandexmusicapi.domain.radio.usecase.RadioUseCase
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import retrofit2.Retrofit

/**
 * Класс предоставляющий работу с радио
 */
class YandexMusicRadio(private val retrofit: Retrofit) {

    /**
     * Создание радио сессии с кастом параметрами
     *
     * @param requestNewRadioSession - запрос кастомной сессии
     * @return сессия и треки
     */
    suspend fun getCustomRadioSession(requestNewRadioSession: RequestNewRadioSession): RadioSessionYandexState {
        val radioRepository =
            RadioModule.provideRadioRepository(RadioModule.provideRadioApi(retrofit))

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
        val radioRepository =
            RadioModule.provideRadioRepository(RadioModule.provideRadioApi(retrofit))

        val requestNewRadioSession = RequestNewRadioSession(
            seeds = listOf("user:onyourwave"),
            includeTracksInResponse = true
        )

        return when (val result =
            RadioUseCase(radioRepository).getNewUserRadioSession(requestNewRadioSession)) {
            is ApiResponse.Failure -> RadioSessionYandexState.Error(result.message())
            is ApiResponse.Success -> RadioSessionYandexState.Success(result.data.result)
        }
    }
}