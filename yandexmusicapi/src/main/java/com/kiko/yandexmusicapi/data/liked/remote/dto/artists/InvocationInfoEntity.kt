package com.kiko.yandexmusicapi.data.liked.remote.dto.artists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InvocationInfoEntity(
    @Json(name = "exec-duration-millis")
    val execDurationMillis: Int,
    @Json(name = "hostname")
    val hostname: String,
    @Json(name = "req-id")
    val reqId: String
)