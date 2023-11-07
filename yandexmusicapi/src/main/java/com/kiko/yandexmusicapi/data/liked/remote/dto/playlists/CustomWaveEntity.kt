package com.kiko.yandexmusicapi.data.liked.remote.dto.playlists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CustomWaveEntity(
    @Json(name = "animationUrl")
    val animationUrl: String,
    @Json(name = "header")
    val header: String,
    @Json(name = "position")
    val position: String,
    @Json(name = "title")
    val title: String
)