package com.kiko.yandexmusicapi.data.account.remote.dto.subsciption.operator

import com.squareup.moshi.JsonClass

/**
 * Класс, представляющий способы деактивации мобильной услуги.
 *
 * **Примечание:**
 * Известные значения поля `method`: `ussd`.

 * @param method Метод отключения.
 * @param instructions Инструкция (опционально).
 */
@JsonClass(generateAdapter = true)
data class DeactivationEntity(
    val method: String,
    val instructions: String? = null
)