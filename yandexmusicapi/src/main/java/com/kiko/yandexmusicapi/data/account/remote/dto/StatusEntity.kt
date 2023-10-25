package com.kiko.yandexmusicapi.data.account.remote.dto

import com.kiko.yandexmusicapi.data.account.remote.dto.AccountEntity
import com.kiko.yandexmusicapi.data.rotor.remote.dto.StationDataEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Класс, представляющий подробную информацию об аккаунте пользователя.
 *
 * @param account основная информация об аккаунте
 * @param permissions информация о правах пользователя
 * @param advertisement рекламное объявление
 * @param subscription информация о подписках
 * @param cacheLimit максимальный размер загруженных треков
 * @param subeditor наличие статуса модератора проверки корректности информации
 * @param subeditorLevel уровень статуса модератора
 * @param plus информация о Plus подписке
 * @param defaultEmail основной e-mail адрес аккаунта
 * @param skipsPerHour количество переключение треков на радио в час
 * @param stationExists наличие личной станции
 * @param stationData информация о личной станции
 * @param barBelow блок с предупреждениями о конце подписке и подарках
 * @param premiumRegion регион TODO
 * @param experiment включенная новая фича на аккаунте (её ID) TODO
 * @param pretrialActive TODO
 * @param userHash хэш-код идентификатора пользователя
 */
@JsonClass(generateAdapter = true)
data class StatusEntity(
    val account: AccountEntity?,
    val permissions: PermissionsEntity?,
    val advertisement: String? = null,
    val subscription: SubscriptionEntity? = null,
    val cacheLimit: Int? = null,
    val subeditor: Boolean? = null,
    val subeditorLevel: Int? = null,
    val plus: PlusEntity? = null,
    val defaultEmail: String? = null,
    val skipsPerHour: Int? = null,
    val stationExists: Boolean? = null,
    val stationData: StationDataEntity? = null,
    val barBelow: AlertEntity? = null,
    val premiumRegion: Int? = null,
    val experiment: Int? = null,
    val pretrialActive: Boolean? = null,
    val userHash: String? = null
)