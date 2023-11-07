package com.kiko.yandexmusicapi.di.account

import com.kiko.yandexmusicapi.data.account.remote.api.AccountApi
import com.kiko.yandexmusicapi.data.account.repository.AccountRepositoryImpl
import com.kiko.yandexmusicapi.domain.account.repository.AccountRepository
import retrofit2.Retrofit

object AccountModule {
    fun provideAccountApi(retrofit: Retrofit): AccountApi {
        return retrofit.create(AccountApi::class.java)
    }

    fun provideAccountRepository(accountApi: AccountApi): AccountRepository {
        return AccountRepositoryImpl(accountApi)
    }
}