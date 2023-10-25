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
    val alertId: String,
    val text: String,
    val backgroundColor: String,
    val textColor: String,
    val alertType: String,
    val button: AlertButtonEntity,
    val closeButton: Boolean
)