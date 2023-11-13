package com.kiko.yandexmusicapi.data.liked.remote.dto.artists

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DescriptionEntity(
    @Json(name = "text")
    val text: String,
    @Json(name = "uri")
    val uri: String
)