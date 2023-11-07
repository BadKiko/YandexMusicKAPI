package com.kiko.yandexmusicapi.data.liked

import com.kiko.yandexmusicapi.data.liked.state.LikedPlaylistsYandexState
import com.kiko.yandexmusicapi.data.common.LikedTracksYandexState
import com.kiko.yandexmusicapi.di.likes.LikedModule
import com.kiko.yandexmusicapi.domain.likes.usecase.LikedUseCase
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import retrofit2.Retrofit

/**
 * Класс предоставляющий работу с лайками
 */
class YandexMusicLiked(private val retrofit: Retrofit) {

    /**
     * Получение всех лайкнутых треков пользователя
     *
     * @param userId - uid пользователя
     * @return результат получения лайкнутых треков
     */
    suspend fun getLikedTracks(userId: String): LikedTracksYandexState {
        val likedTracksRepository =
            LikedModule.provideLikedRepository(LikedModule.provideLikedApi(retrofit))

        return when (val result = LikedUseCase(likedTracksRepository).getTracks(userId)) {
            is ApiResponse.Failure -> LikedTracksYandexState.Error(result.message())
            is ApiResponse.Success -> LikedTracksYandexState.Success(result.data.result)
        }
    }


    /**
     * Получение всех лайкнутых плейлистов пользователя
     *
     * @param userId - uid пользователя
     * @return результат получения всех лайкнутых плейлистов
     */
    suspend fun getLikedPlaylists(userId: String): LikedPlaylistsYandexState {
        val likedTracksRepository =
            LikedModule.provideLikedRepository(LikedModule.provideLikedApi(retrofit))

        return when (val result = LikedUseCase(likedTracksRepository).getPlaylists(userId)) {
            is ApiResponse.Failure -> LikedPlaylistsYandexState.Error(result.message())
            is ApiResponse.Success -> LikedPlaylistsYandexState.Success(result.data.result)
        }
    }
}