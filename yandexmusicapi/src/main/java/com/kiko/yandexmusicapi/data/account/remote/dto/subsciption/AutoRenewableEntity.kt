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
    @Json(name = "vendor_help_url") val vendorHelpUrl: String,
    val product: ProductEntity? = null,
    val finished: Boolean,
    @Json(name = "master_info") val masterInfo: UserEntity? = null,
    @Json(name = "product_id") val productId: String? = null,
    @Json(name = "order_id") val orderId: Int? = null
)