package com.kiko.yandexmusicapi.data.account.remote.dto.account

import com.squareup.moshi.JsonClass

/**
 * Класс, представляющий номер телефона пользователя.
 * @param phone Номер телефона
 */
@JsonClass(generateAdapter = true)
data class PassportPhoneEntity(
    val phone: String
)

