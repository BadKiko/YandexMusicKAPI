package com.kiko.yandexmusicapi.data.account.remote.dto

import com.kiko.yandexmusicapi.data.account.remote.dto.subsciption.AutoRenewableEntity
import com.kiko.yandexmusicapi.data.account.remote.dto.subsciption.NonAutoRenewableEntity
import com.kiko.yandexmusicapi.data.account.remote.dto.subsciption.OperatorEntity
import com.kiko.yandexmusicapi.data.account.remote.dto.subsciption.RenewableRemainderEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий информацию о подписках пользователя.
 *
 * @param nonAutoRenewableRemainder Напоминание о продлении.
 * @param autoRenewable Автопродление.
 * @param familyAutoRenewable Автопродление семейной подписки.
 * @param operator Услуги сотового оператора.
 * @param nonAutoRenewable Отключённое автопродление.
 * @param canStartTrial Возможность начать пробный период.
 * @param mcDonalds mcdonalds TODO.
 * @param end Дата окончания.
 * @param hadAnySubscription Наличие какой-либо подписки в прошлом.
 */

@JsonClass(generateAdapter = true)
data class SubscriptionEntity(
    @Json(name = "non_auto_renewable_remainder") val nonAutoRenewableRemainder: RenewableRemainderEntity,
    @Json(name = "auto_renewable") val autoRenewable: List<AutoRenewableEntity>,
    @Json(name = "family_auto_renewable") val familyAutoRenewable: List<AutoRenewableEntity>,
    @Json(name = "had_any_subscription") val hadAnySubscription: Boolean,
    val operator: List<OperatorEntity>? = null,
    @Json(name = "non_auto_renewable") val nonAutoRenewable: NonAutoRenewableEntity? = null,
    @Json(name = "can_start_trial") val canStartTrial: Boolean? = null,
    @Json(name = "mcdonalds") val mcDonalds: Boolean? = null,
    val end: String? = null,
)
