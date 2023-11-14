package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackPositionEntity(
    @Json(name = "index")
    val index: Int,
    @Json(name = "volume")
    val volume: Int
)