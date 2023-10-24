package com.kiko.yandexmusicapi.data.account.remote.dto

import com.squareup.moshi.JsonClass

/**
 * Класс, представляющий информацию о правах пользователя, их изначальных значениях и даты окончания.
 *
 * @param until Дата окончания прав.
 * @param values Список прав.
 * @param default Список изначальных прав.
 */
@JsonClass(generateAdapter = true)
data class PermissionsEntity(
    val until: String,
    val values: List<String>,
    val default: List<String>
)