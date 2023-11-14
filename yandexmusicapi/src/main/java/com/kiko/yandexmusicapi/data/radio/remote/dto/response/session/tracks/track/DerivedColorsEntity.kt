package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DerivedColorsEntity(
    @Json(name = "accent")
    val accent: String,
    @Json(name = "average")
    val average: String,
    @Json(name = "miniPlayer")
    val miniPlayer: String,
    @Json(name = "waveText")
    val waveText: String
)