package com.kiko.yandexmusicapi.data.account.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий пользователя.
 *
 * @param uid Идентификатор пользователя.
 * @param login Логин пользователя.
 * @param name Имя пользователя (опционально).
 * @param displayName Отображаемое имя пользователя (опционально).
 * @param fullName Полное имя пользователя (опционально).
 * @param sex Пол пользователя (опционально).
 * @param verified Участвует ли пользователь в генерации плейлистов дня и т.д., и т.п. (опционально).
 * @param regions Список регионов (опционально).
 *
 * **Примечания:**
 * Когда данный класс используется в `MadeFor` и `Playlist`, то доступны все поля кроме `display_name` и `full_name`.
 * При наличии экземпляра класса в `user_info` у `Track` (у самозагруженных треков) доступны только `uid`, '`login`, 'display_name` и `full_name`.
 * Поле `regions` есть только при возвращении пользователей в результатах поисках.
 */
@JsonClass(generateAdapter = true)
data class UserEntity(
    val uid: Int,
    val login: String,
    val name: String? = null,
    @Json(name = "display_name") val displayName: String? = null,
    @Json(name = "full_name") val fullName: String? = null,
    val sex: String? = null,
    val verified: Boolean? = null,
    val regions: List<Int>? = null,
)