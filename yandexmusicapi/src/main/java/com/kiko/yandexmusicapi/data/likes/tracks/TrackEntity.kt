package com.kiko.yandexmusicapi.data.likes.tracks


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackEntity(
    @Json(name = "albumId")
    val albumId: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "timestamp")
    val timestamp: String
)