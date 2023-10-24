package com.kiko.yandexmusicapi.data.account.remote.dto

import com.kiko.yandexmusicapi.data.account.remote.dto.alert.AlertButtonEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий блок с предупреждением.
 *
 * **Примечание:**
 * Данные предупреждения, скорее всего, только обкатываются. У них нет ID, вместо этого `xxx`, а еще присутствуют
   слова "тест" в тексте.

 * Используют как предупреждение о конце подписки, так и о раздаче подарков.

 * @param alertId Уникальный идентификатор.
 * @param text Текст предупреждения.
 * @param backgroundColor Цвет заднего фона.
 * @param textColor Цвет текста.
 * @param alertType Тип предупреждения.
 * @param button Кнопка с ссылкой.
 * @param closeButton Наличие кнопки "Закрыть".
 */
@JsonClass(generateAdapter = true)
data class AlertEntity(
    @Json(name = "alert_id") val alertId: String,
    val text: String,
    @Json(name = "background_color") val backgroundColor: String,
    @Json(name = "text_color") val textColor: String,
    @Json(name = "alert_type") val alertType: String,
    val button: AlertButtonEntity,
    @Json(name = "close_button") val closeButton: Boolean
)