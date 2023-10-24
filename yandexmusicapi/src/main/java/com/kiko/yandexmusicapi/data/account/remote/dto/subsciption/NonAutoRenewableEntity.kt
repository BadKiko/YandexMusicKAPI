package com.kiko.yandexmusicapi.data.account.remote.dto.subsciption

import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий отключённое автопродление.
 *
 * @param start Дата начала подписки.
 * @param end Дата окончания подписки.
 */
@JsonClass(generateAdapter = true)
data class NonAutoRenewableEntity(
    val start: String,
    val end: String
)