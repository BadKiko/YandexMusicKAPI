package com.kiko.yandexmusicapi.data.account.remote.dto.alert

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий кнопку в предупреждении.
 *
 * @param text Текст кнопки.
 * @param backgroundColor Цвет заднего фона.
 * @param textColor Цвет текста.
 * @param uri Ссылка куда ведёт кнопка.
 */
@JsonClass(generateAdapter = true)
data class AlertButtonEntity(
    val text: String,
    val backgroundColor: String,
    val textColor: String,
    val uri: String
)