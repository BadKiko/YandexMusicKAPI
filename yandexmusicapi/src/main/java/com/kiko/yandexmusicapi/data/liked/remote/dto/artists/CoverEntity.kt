package com.kiko.yandexmusicapi.data.liked.remote.dto.artists


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