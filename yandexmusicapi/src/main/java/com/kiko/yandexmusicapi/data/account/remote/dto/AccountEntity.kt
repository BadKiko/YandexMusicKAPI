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
    val serviceAvailable: Boolean,
    val region: Int? = null,
    val uid: Int? = null,
    val login: String? = null,
    val fullName: String? = null,
    val secondName: String? = null,
    val firstName: String? = null,
    val displayName: String? = null,
    val hostedUser: Boolean? = null,
    val birthday: String? = null,
    val passportPhones: List<PassportPhoneEntity>? = null,
    val registeredAt: String? = null,
    val child: Boolean,
    val nonOwnerFamilyMember: Boolean
)