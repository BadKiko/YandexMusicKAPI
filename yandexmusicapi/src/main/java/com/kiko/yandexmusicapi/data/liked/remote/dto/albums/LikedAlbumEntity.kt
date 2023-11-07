package com.kiko.yandexmusicapi.data.liked.remote.dto.albums

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LikedAlbumEntity(
    @Json(name = "id")
    val id: Int,
    @Json(name = "timestamp")
    val timestamp: String
)