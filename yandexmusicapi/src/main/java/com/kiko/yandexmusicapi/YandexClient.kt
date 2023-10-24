package com.kiko.yandexmusicapi

import com.kiko.yandexmusicapi.constants.YandexMusicConstants

/**
 * Основной класс библиотеки, представляет клиент Yandex Music
 *
 * @param token Уникальный ключ для аутенфикации
 * @param baseUrl Адрес на Yandex Music Api
 */
class YandexClient(
    val token: String,
    val baseUrl: String = YandexMusicConstants.baseUrl
) {
    companion object {
        fun create(token: String, baseUrl: String = YandexMusicConstants.baseUrl): YandexClient {
            return YandexClient(token, baseUrl)
        }
    }


}
