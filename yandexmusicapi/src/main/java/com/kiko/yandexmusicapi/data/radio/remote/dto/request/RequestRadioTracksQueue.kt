package com.kiko.yandexmusicapi.data.radio.remote.dto.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestRadioTracksQueue(
    @Json(name = "queue")
    val queue: List<Int?>
)