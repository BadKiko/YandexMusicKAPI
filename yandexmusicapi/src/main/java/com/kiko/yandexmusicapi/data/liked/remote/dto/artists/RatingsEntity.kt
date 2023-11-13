package com.kiko.yandexmusicapi.data.liked.remote.dto.artists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RatingsEntity(
    @Json(name = "day")
    val day: Int,
    @Json(name = "month")
    val month: Int,
    @Json(name = "week")
    val week: Int
)