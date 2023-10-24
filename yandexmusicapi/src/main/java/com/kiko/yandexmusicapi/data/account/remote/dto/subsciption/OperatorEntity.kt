package com.kiko.yandexmusicapi.data.account.remote.dto.subsciption

import com.kiko.yandexmusicapi.data.account.remote.dto.subsciption.operator.DeactivationEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий услугу сотового оператора.
 *
 * @param productId Уникальный идентификатор продукта сервиса Яндекс.Музыка.
 * @param phone Мобильный номер, на который подключена услуга.
 * @param paymentRegularity Регулярность оплаты.
 * @param deactivation Способы деактивации.
 * @param title Название услуги.
 * @param suspended Приостановлено.
 */
@JsonClass(generateAdapter = true)
data class OperatorEntity(
    @Json(name = "product_id") val productId: String,
    val phone: String,
    @Json(name = "payment_regularity") val paymentRegularity: String,
    val deactivation: List<DeactivationEntity>,
    val title: String,
    val suspended: Boolean
)