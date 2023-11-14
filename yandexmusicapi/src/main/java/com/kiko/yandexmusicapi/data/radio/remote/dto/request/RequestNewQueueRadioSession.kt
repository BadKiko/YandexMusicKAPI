package com.kiko.yandexmusicapi.data.radio.remote.dto.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestNewQueueRadioSession(
    val queue: List<Int>
)