package com.kiko.yandexmusicapi.data.liked.remote.api

import com.kiko.yandexmusicapi.data.liked.remote.dto.playlists.LikedPlaylistsEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.tracks.LikedTracksEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LikedApi {
    @GET("users/{user_id}/likes/tracks")
    fun getLikedTracks(@Path("user_id") userId: String) : Call<ResultWrapper<LikedTracksEntity>>

    @GET("users/{user_id}/likes/playlists")
    fun getLikedPlaylists(@Path("user_id") userId: String) : Call<ResultWrapper<List<LikedPlaylistsEntity>>>

}