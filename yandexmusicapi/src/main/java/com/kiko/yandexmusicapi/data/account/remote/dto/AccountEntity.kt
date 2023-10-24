package com.kiko.yandexmusicapi.data.account.remote.dto

import com.kiko.yandexmusicapi.data.account.remote.dto.account.PassportPhoneEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий основную информацию об аккаунте пользователя.
 *
 * @param now Текущая дата и время.
 * @param uid Уникальный идентификатор.
 * @param login Виртуальное имя (обычно e-mail).
 * @param fullName Полное имя (имя и фамилия).
 * @param secondName Фамилия.
 * @param firstName Имя.
 * @param displayName Отображаемое имя.
 * @param serviceAvailable Доступен ли сервис.
 * @param hostedUser Является ли пользователем чьим-то другим.
 * @param birthday Дата рождения.
 * @param region Регион.
 * @param passportPhones Мобильные номера.
 * @param registeredAt Дата создания учётной записи.
 * @param hasInfoForAppMetrica Наличие информации для App Metrica.
 * @param child Дочерний / детский аккаунт.
 */

@JsonClass(generateAdapter = true)
data class AccountEntity(
    val now: String,
    @Json(name = "service_available") val serviceAvailable: Boolean,
    val region: Int? = null,
    val uid: Int? = null,
    val login: String? = null,
    @Json(name = "full_name") val fullName: String? = null,
    @Json(name = "second_name") val secondName: String? = null,
    @Json(name = "first_name") val firstName: String? = null,
    @Json(name = "display_name") val displayName: String? = null,
    @Json(name = "hosted_user") val hostedUser: Boolean? = null,
    val birthday: String? = null,
    @Json(name = "passport_phones") val passportPhones: List<PassportPhoneEntity>? = null,
    @Json(name = "registered_at") val registeredAt: String? = null,
    @Json(name = "has_info_for_app_metrica") val hasInfoForAppMetrica: Boolean? = null,
    val child: Boolean
)