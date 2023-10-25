package com.kiko.yandexmusicapi.data.remote

import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Обертка для возвращения правильного ответа от апи яндекса
 */
@JsonClass(generateAdapter = true)
data class ResultWrapper<T>(
    val invocationInfo: InvocationInfoEntity,
    val result: T
)


/**
 * Доп информация о запросе
 *
 * @param reqId id запроса в апи яндекса
 * @param hostname имя сервера куда стучимся
 * @param execDurationTime время выполнения запроса
 */
@JsonClass(generateAdapter = true)
data class InvocationInfoEntity(
    @Json(name = "req-id") val reqId: String,
    val hostname: String,
    @Json(name = "exec-duration-millis") val execDurationTime: Int
)