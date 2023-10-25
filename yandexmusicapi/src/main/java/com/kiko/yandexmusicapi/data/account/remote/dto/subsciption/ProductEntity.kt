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
    val productId: String,
    val type: String,
    val commonPeriodDuration: String,
    val duration: Int,
    val trialDuration: Int,
    val price: PriceEntity?,
    val feature: String,
    val debug: Boolean,
    val plus: Boolean,
    val cheapest: Boolean? = null,
    val title: String? = null,
    val familySub: Boolean? = null,
    val fbImage: String? = null,
    val fbName: String? = null,
    val family: Boolean? = null,
    val features: List<String>? = null,
    val description: String? = null,
    val available: Boolean? = null,
    val trialAvailable: Boolean? = null,
    val trialPeriodDuration: String? = null,
    val introPeriodDuration: String? = null,
    val introPrice: PriceEntity? = null,
    val startPeriodDuration: String? = null,
    val startPrice: PriceEntity? = null,
    val licenceTextParts: List<PriceEntity>? = null,
    val vendorTrialAvailable: Boolean? = null,
    val buttonText: String? = null,
    val buttonAdditionalText: String? = null,
    val paymentMethodTypes: List<String>? = null,
)