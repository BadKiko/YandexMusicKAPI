package com.kiko.yandexmusicapi.data.remote

import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ResultWrapper<T>(
    val invocationInfo: InvocationInfoEntity,
    val result: T
)


@JsonClass(generateAdapter = true)
data class InvocationInfoEntity(
    @Json(name = "req-id") val reqId: String,
    val hostname: String,
    @Json(name = "exec-duration-millis") val execDurationTime: Int
)