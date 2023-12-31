package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LabelEntity(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)