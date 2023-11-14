package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AcceptedSeedEntity(
    @Json(name = "tag")
    val tag: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "value")
    val value: String
)