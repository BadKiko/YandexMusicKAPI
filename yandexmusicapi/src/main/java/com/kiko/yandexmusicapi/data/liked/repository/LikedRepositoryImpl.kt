package com.kiko.yandexmusicapi.data.liked.repository

import com.kiko.yandexmusicapi.data.liked.remote.api.LikedApi
import com.kiko.yandexmusicapi.data.liked.remote.dto.albums.LikedAlbumEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.playlists.LikedPlaylistsEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.tracks.LikedTracksEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import com.kiko.yandexmusicapi.domain.likes.repository.LikedRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.request
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LikedRepositoryImpl(private val likedApi: LikedApi) : LikedRepository {
    override suspend fun getLikedTracks(userId: String): ApiResponse<ResultWrapper<LikedTracksEntity>> {
        return suspendCoroutine { continuation ->
            likedApi.getLikedTracks(userId).request {
                continuation.resume(it)
            }
        }
    }

    override suspend fun getLikedPlaylists(userId: String): ApiResponse<ResultWrapper<List<LikedPlaylistsEntity>>> {
        return suspendCoroutine { continuation ->
            likedApi.getLikedPlaylists(userId).request {
                continuation.resume(it)
            }
        }
    }

    override suspend fun getLikedAlbums(userId: String): ApiResponse<ResultWrapper<List<LikedAlbumEntity>>> {
        return suspendCoroutine { continuation ->
            likedApi.getLikedAlbums(userId).request {
                continuation.resume(it)
            }
        }
    }
}