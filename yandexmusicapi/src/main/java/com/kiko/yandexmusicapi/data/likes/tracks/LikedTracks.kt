package com.kiko.yandexmusicapi.data.likes.tracks


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LikedTracks(
    @Json(name = "library")
    val library: LikedTrackEntity
)