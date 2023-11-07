package com.kiko.yandexmusicapi.domain.likes.usecase

import com.kiko.yandexmusicapi.data.liked.remote.dto.playlists.LikedPlaylistsEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.tracks.LikedTracksEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import com.kiko.yandexmusicapi.domain.likes.repository.LikedRepository
import com.skydoves.sandwich.ApiResponse

class LikedUseCase (private val likedRepository: LikedRepository) {
    suspend fun getTracks(userId: String): ApiResponse<ResultWrapper<LikedTracksEntity>> {
        return likedRepository.getLikedTracks(userId)
    }

    suspend fun getPlaylists(userId: String): ApiResponse<ResultWrapper<List<LikedPlaylistsEntity>>> {
        return likedRepository.getLikedPlaylists(userId)
    }
}