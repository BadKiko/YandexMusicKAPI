package com.kiko.yandexmusicapi.data.account.remote.dto.subsciption.product

import com.squareup.moshi.JsonClass

/**
 * Класс, представляющий цену.
 *
 * @param amount Количество единиц.
 * @param currency Валюта.
 */
@JsonClass(generateAdapter = true)
data class PriceEntity(
    val amount: Int,
    val currency: String
)
