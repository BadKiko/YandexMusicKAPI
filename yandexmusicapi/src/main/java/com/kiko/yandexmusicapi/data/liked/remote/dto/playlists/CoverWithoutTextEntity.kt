package com.kiko.yandexmusicapi.data.liked.remote.dto.playlists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoverWithoutTextEntity(
    @Json(name = "custom")
    val custom: Boolean,
    @Json(name = "dir")
    val dir: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "uri")
    val uri: String,
    @Json(name = "version")
    val version: String
)