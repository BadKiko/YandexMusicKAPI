package com.kiko.yandexmusicapi.data.account.remote.dto.subsciption

import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий напоминания о продлении подписки.
 *
 * @property days Количество дней до окончания подписки.
 *
 * **Примечание:**
 * Присутствует только тогда, когда автопродление отключено.
 */
@JsonClass(generateAdapter = true)
data class RenewableRemainderEntity(
    val days: Int
)