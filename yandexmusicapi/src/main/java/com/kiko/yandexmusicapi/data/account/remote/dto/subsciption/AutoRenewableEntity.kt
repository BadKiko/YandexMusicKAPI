package com.kiko.yandexmusicapi.data.account.remote.dto.subsciption

import com.kiko.yandexmusicapi.data.account.remote.dto.UserEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Класс, представляющий информацию об автопродлении подписки.
 *
 * @param expires Дата истечения подписки.
 * @param vendor Продавец.
 * @param vendorHelpUrl Ссылка на страницу помощи продавца.
 * @param productId Уникальный идентификатор продукта.
 * @param finished Завершенность автопродления.
 * @param masterInfo Главный в семейной подписке.
 * @param product Продукт.
 * @param orderId Уникальный идентификатор заказа.
 */
@JsonClass(generateAdapter = true)
data class AutoRenewableEntity(
    val expires: String,
    val vendor: String,
    val vendorHelpUrl: String,
    val product: ProductEntity? = null,
    val finished: Boolean,
    val masterInfo: UserEntity? = null,
    val productId: String? = null,
    val orderId: Int? = null
)