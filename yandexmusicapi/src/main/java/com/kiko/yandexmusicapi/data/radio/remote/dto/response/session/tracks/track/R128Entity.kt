package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class R128Entity(
    @Json(name = "i")
    val i: Double,
    @Json(name = "tp")
    val tp: Double
)