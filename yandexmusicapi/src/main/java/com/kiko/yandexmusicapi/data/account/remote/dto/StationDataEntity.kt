package com.kiko.yandexmusicapi.data.account.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StationDataEntity(
    val name: String
)