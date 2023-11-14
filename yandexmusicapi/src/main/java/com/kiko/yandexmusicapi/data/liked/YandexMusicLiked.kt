package com.kiko.yandexmusicapi.data.liked

import com.kiko.yandexmusicapi.data.liked.state.LikedPlaylistsYandexState
import com.kiko.yandexmusicapi.data.common.LikedTracksYandexState
import com.kiko.yandexmusicapi.data.liked.state.LikedAlbumYandexState
import com.kiko.yandexmusicapi.data.liked.state.LikedArtistsYandexState
import com.kiko.yandexmusicapi.di.likes.LikedModule
import com.kiko.yandexmusicapi.domain.likes.usecase.LikedUseCase
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import retrofit2.Retrofit

/**
 * Класс предоставляющий работу с лайками
 */
class YandexMusicLiked(private val retrofit: Retrofit) {
    private val likedTracksRepository =
        LikedModule.provideLikedRepository(LikedModule.provideLikedApi(retrofit))

    /**
     * Получение всех лайкнутых треков пользователя
     *
     * @param userId - uid пользователя
     * @return результат получения лайкнутых треков
     */
    suspend fun getLikedTracks(userId: String): LikedTracksYandexState {
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
        return when (val result = LikedUseCase(likedTracksRepository).getPlaylists(userId)) {
            is ApiResponse.Failure -> LikedPlaylistsYandexState.Error(result.message())
            is ApiResponse.Success -> LikedPlaylistsYandexState.Success(result.data.result)
        }
    }

    /**
     * Получение всех лайкнутых альбомов пользователя
     *
     * @param userId - uid пользователя
     * @return результат получения всех лайкнутых альбомов
     */
    suspend fun getLikedAlbums(userId: String): LikedAlbumYandexState {
        return when (val result = LikedUseCase(likedTracksRepository).getAlbums(userId)) {
            is ApiResponse.Failure -> LikedAlbumYandexState.Error(result.message())
            is ApiResponse.Success -> LikedAlbumYandexState.Success(result.data.result)
        }
    }

    /**
     * Получение всех лайкнутых артистов пользователя
     *
     * @param userId - uid пользователя
     * @return результат получения всех лайкнутых артистов
     */
    suspend fun getLikedArtists(userId: String): LikedArtistsYandexState {
        return when (val result = LikedUseCase(likedTracksRepository).getArtists(userId)) {
            is ApiResponse.Failure -> LikedArtistsYandexState.Error(result.message())
            is ApiResponse.Success -> LikedArtistsYandexState.Success(result.data.result)
        }
    }
}