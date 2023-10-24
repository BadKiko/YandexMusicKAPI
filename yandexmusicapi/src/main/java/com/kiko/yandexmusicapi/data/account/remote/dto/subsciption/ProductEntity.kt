package com.kiko.yandexmusicapi.data.account.remote.dto.subsciption

import com.kiko.yandexmusicapi.data.account.remote.dto.subsciption.product.PriceEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий продаваемый продукт.
 *
 * @param productId Уникальный идентификатор.
 * @param type Тип продаваемого.
 * @param commonPeriodDuration Длительность общего периода.
 * @param duration Длительность.
 * @param trialDuration Длительность испытательного срока.
 * @param price Цена.
 * @param feature Предоставляемая возможность.
 * @param debug Отладочный продукт.
 * @param plus Даёт ли подписку "Плюс".
 * @param title Заголовок продукта.
 * @param familySub Семейная ли подписка.
 * @param fbImage Картинка для превью на facebook.
 * @param fbName Заголовок превью на facebook.
 * @param family Доступно ли для семьи.
 * @param features Список предоставляемых возможностей.
 * @param description Описание.
 * @param available Доступна ли покупка.
 * @param trialAvailable Доступен ли пробный период.
 * @param trialPeriodDuration Длительность пробного периода.
 * @param introPeriodDuration Длительность вступительного периода.
 * @param introPrice Цена вступительного периода.
 * @param startPeriodDuration Длительность первого срока (за меньшую цену).
 * @param startPrice Цена за первый срок.
 * @param licenceTextParts Список частей лицензионного текста.
 * @param vendorTrialAvailable Доступен испытательный срок продавца.
 * @param buttonText Текст кнопки.
 * @param buttonAdditionalText Дополнительный текст кнопки.
 * @param paymentMethodTypes Способы оплаты.
 */
@JsonClass(generateAdapter = true)
data class ProductEntity(
    @Json(name = "product_id") val productId: String,
    val type: String,
    @Json(name = "common_period_duration") val commonPeriodDuration: String,
    val duration: Int,
    @Json(name = "trial_duration") val trialDuration: Int,
    val price: PriceEntity?,
    val feature: String,
    val debug: Boolean,
    val plus: Boolean,
    val cheapest: Boolean? = null,
    val title: String? = null,
    @Json(name = "family_sub") val familySub: Boolean? = null,
    @Json(name = "fb_image") val fbImage: String? = null,
    @Json(name = "fb_name") val fbName: String? = null,
    val family: Boolean? = null,
    val features: List<String>? = null,
    val description: String? = null,
    val available: Boolean? = null,
    @Json(name = "trial_available") val trialAvailable: Boolean? = null,
    @Json(name = "trial_period_duration") val trialPeriodDuration: String? = null,
    @Json(name = "intro_period_duration") val introPeriodDuration: String? = null,
    @Json(name = "intro_price") val introPrice: PriceEntity? = null,
    @Json(name = "start_period_duration") val startPeriodDuration: String? = null,
    @Json(name = "start_price") val startPrice: PriceEntity? = null,
    @Json(name = "licence_text_parts") val licenceTextParts: List<PriceEntity>? = null,
    @Json(name = "vendor_trial_available") val vendorTrialAvailable: Boolean? = null,
    @Json(name = "button_text") val buttonText: String? = null,
    @Json(name = "button_additional_text") val buttonAdditionalText: String? = null,
    @Json(name = "payment_method_types") val paymentMethodTypes: List<String>? = null,
)