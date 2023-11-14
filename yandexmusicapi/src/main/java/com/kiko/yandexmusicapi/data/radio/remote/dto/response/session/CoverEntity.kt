package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoverEntity(
    @Json(name = "prefix")
    val prefix: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "uri")
    val uri: String
)