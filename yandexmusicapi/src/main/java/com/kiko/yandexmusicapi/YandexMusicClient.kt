package com.kiko.yandexmusicapi

import com.kiko.yandexmusicapi.constants.YandexMusicConstants
import com.kiko.yandexmusicapi.data.account.module.AccountModule
import com.kiko.yandexmusicapi.data.common.StatusEntityYandexState
import com.kiko.yandexmusicapi.di.RetrofitModule
import com.kiko.yandexmusicapi.domain.account.usecase.AccountUseCase
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
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
    private lateinit var retrofit: Retrofit

    companion object {
        fun create(token: String, baseUrl: String = YandexMusicConstants.baseUrl): YandexMusicClient {
            val yandexMusicClient = YandexMusicClient(token, baseUrl)
            yandexMusicClient.retrofit =
                RetrofitModule.provideRetrofit(RetrofitModule.provideHttpClient(yandexMusicClient = yandexMusicClient))
            return yandexMusicClient
        }
    }

    suspend fun getAccountStatus(): StatusEntityYandexState {
        val accountRepository =
            AccountModule.provideAccountRepository(AccountModule.provideAccountApi(retrofit))

        return when (val result = AccountUseCase(accountRepository).getStatus()) {
            is ApiResponse.Failure -> StatusEntityYandexState.Error(result.message())
            is ApiResponse.Success -> StatusEntityYandexState.Success(result.data.result)
        }
    }
}
