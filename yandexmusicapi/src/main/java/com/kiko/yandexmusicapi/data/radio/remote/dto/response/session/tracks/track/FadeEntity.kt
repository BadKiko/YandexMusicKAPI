package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FadeEntity(
    @Json(name = "inStart")
    val inStart: Double,
    @Json(name = "inStop")
    val inStop: Double,
    @Json(name = "outStart")
    val outStart: Double,
    @Json(name = "outStop")
    val outStop: Double
)