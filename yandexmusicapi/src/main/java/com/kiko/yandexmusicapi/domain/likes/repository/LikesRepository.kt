package com.kiko.yandexmusicapi.domain.likes.repository

import com.kiko.yandexmusicapi.data.liked.remote.dto.albums.LikedAlbumEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.artists.LikedArtistsEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.playlists.LikedPlaylistsEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.tracks.LikedTracksEntity
import com.kiko.yandexmusicapi.data.common.remote.ResultWrapper
import com.skydoves.sandwich.ApiResponse

interface LikedRepository {
    suspend fun getLikedTracks(userId: String): ApiResponse<ResultWrapper<LikedTracksEntity>>
    suspend fun getLikedPlaylists(userId: String): ApiResponse<ResultWrapper<List<LikedPlaylistsEntity>>>
    suspend fun getLikedAlbums(userId: String): ApiResponse<ResultWrapper<List<LikedAlbumEntity>>>
    suspend fun getLikedArtists(userId: String): ApiResponse<ResultWrapper<List<LikedArtistsEntity>>>

}