package com.kiko.yandexmusicapi

import com.kiko.yandexmusicapi.constants.YandexMusicConstants
import com.kiko.yandexmusicapi.data.account.YandexMusicAccount
import com.kiko.yandexmusicapi.data.liked.YandexMusicLiked
import com.kiko.yandexmusicapi.di.common.RetrofitModule
import retrofit2.Retrofit

/**
 * Основной класс библиотеки, представляет клиент Yandex Music
 *
 * @param token Уникальный ключ для аутенфикации
 * @param baseUrl Адрес на Yandex Music Api
 */
class YandexMusicClient(
    val token: String,
    val baseUrl: String = YandexMusicConstants.baseUrl
) {
    internal lateinit var retrofit: Retrofit

    companion object {
        fun create(
            token: String,
            baseUrl: String = YandexMusicConstants.baseUrl
        ): YandexMusicClient {
            val yandexMusicClient = YandexMusicClient(token, baseUrl)
            yandexMusicClient.retrofit =
                RetrofitModule.provideRetrofit(RetrofitModule.provideHttpClient(yandexMusicClient = yandexMusicClient))
            return yandexMusicClient
        }
    }

    fun getAccount() = YandexMusicAccount(retrofit)
    fun getLiked() = YandexMusicLiked(retrofit)
}
