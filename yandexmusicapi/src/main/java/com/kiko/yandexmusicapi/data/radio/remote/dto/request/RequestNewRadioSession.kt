package com.kiko.yandexmusicapi.data.radio.remote.dto.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestNewRadioSession(
    val seeds: List<String>,
    val includeTracksInResponse: Boolean
)