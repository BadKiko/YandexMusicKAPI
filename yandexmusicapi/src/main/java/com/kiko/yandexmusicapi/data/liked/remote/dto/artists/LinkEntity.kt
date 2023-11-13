package com.kiko.yandexmusicapi.data.liked.remote.dto.artists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinkEntity(
    @Json(name = "href")
    val href: String,
    @Json(name = "socialNetwork")
    val socialNetwork: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: String
)