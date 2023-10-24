package com.kiko.yandexmusicapi.data.account.remote.dto

import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий `Plus` подписку.
 *
 * @param hasPlus Наличие.
 * @param isTutorialCompleted Закончено ли руководство.
 */
@JsonClass(generateAdapter = true)
data class PlusEntity(
    val hasPlus: Boolean,
    val isTutorialCompleted: Boolean
)