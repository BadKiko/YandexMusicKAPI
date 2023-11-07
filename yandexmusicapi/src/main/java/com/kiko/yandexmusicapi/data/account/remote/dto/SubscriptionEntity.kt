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
    val nonAutoRenewableRemainder: RenewableRemainderEntity? = null,
    val autoRenewable: List<AutoRenewableEntity>? = null,
    val familyAutoRenewable: List<AutoRenewableEntity>? = null,
    val hadAnySubscription: Boolean,
    val operator: List<OperatorEntity>? = null,
    val nonAutoRenewable: NonAutoRenewableEntity? = null,
    val canStartTrial: Boolean? = null,
    val mcDonalds: Boolean? = null,
    val end: String? = null,
)
