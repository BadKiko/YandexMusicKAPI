package com.kiko.yandexmusicapi.data.liked.remote.dto.playlists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LikedPlaylistsEntity(
    @Json(name = "playlist")
    val playlistEntity: PlaylistEntity,
    @Json(name = "timestamp")
    val timestamp: String
)