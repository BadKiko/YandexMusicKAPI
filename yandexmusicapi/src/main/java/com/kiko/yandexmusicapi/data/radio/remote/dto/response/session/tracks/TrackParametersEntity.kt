package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackParametersEntity(
    @Json(name = "bpm")
    val bpm: Int,
    @Json(name = "energy")
    val energy: Double,
    @Json(name = "hue")
    val hue: Double
)