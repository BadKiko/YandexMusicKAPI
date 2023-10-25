package com.kiko.yandexmusicapi

import com.kiko.yandexmusicapi.constants.YandexMusicConstants
import com.kiko.yandexmusicapi.data.account.module.AccountModule
import com.kiko.yandexmusicapi.di.RetrofitModule
import com.kiko.yandexmusicapi.domain.account.usecase.AccountUseCase
import kotlinx.coroutines.flow.collectLatest
import retrofit2.Retrofit

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
    private lateinit var retrofit: Retrofit

    companion object {
        fun create(token: String, baseUrl: String = YandexMusicConstants.baseUrl): YandexClient {
            val yandexClient = YandexClient(token, baseUrl)
            yandexClient.retrofit =
                RetrofitModule.provideRetrofit(RetrofitModule.provideHttpClient(yandexClient = yandexClient))
            return yandexClient
        }
    }

    suspend fun getAccountStatus() {
        val accountRepository =
            AccountModule.provideAccountRepository(AccountModule.provideAccountApi(retrofit))
        AccountUseCase(accountRepository).getStatus().collectLatest {
            it
        }
    }
}
