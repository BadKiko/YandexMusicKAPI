package com.kiko.yandexmusicapi.data.liked.remote.dto.tracks


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LikedTrackEntity(
    @Json(name = "playlistUuid")
    val playlistUuid: String,
    @Json(name = "revision")
    val revision: Int,
    @Json(name = "tracks")
    val tracks: List<TrackEntity>,
    @Json(name = "uid")
    val uid: Int
)