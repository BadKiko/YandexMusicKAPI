package com.kiko.yandexmusicapi.data.account

import com.kiko.yandexmusicapi.data.common.AccountYandexState
import com.kiko.yandexmusicapi.di.account.AccountModule
import com.kiko.yandexmusicapi.domain.account.usecase.AccountUseCase
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import retrofit2.Retrofit

class YandexMusicAccount(private val retrofit: Retrofit) {
    /**
     * Получение данных аккаунта
     *
     * @return возвращает результат получения данных
     */
    suspend fun getAccountStatus(): AccountYandexState {
        val accountRepository =
            AccountModule.provideAccountRepository(AccountModule.provideAccountApi(retrofit))

        return when (val result = AccountUseCase(accountRepository).getStatus()) {
            is ApiResponse.Failure -> AccountYandexState.Error(result.message())
            is ApiResponse.Success -> AccountYandexState.Success(result.data.result)
        }
    }
}