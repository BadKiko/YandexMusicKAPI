package com.kiko.yandexmusicapi.di.radio

import com.kiko.yandexmusicapi.data.liked.remote.api.LikedApi
import com.kiko.yandexmusicapi.data.liked.repository.LikedRepositoryImpl
import com.kiko.yandexmusicapi.data.radio.remote.api.RadioApi
import com.kiko.yandexmusicapi.data.radio.repository.RadioRepositoryImpl
import com.kiko.yandexmusicapi.domain.likes.repository.LikedRepository
import com.kiko.yandexmusicapi.domain.radio.repository.RadioRepository
import retrofit2.Retrofit

object RadioModule {
    fun provideRadioApi(retrofit: Retrofit): RadioApi {
        return retrofit.create(RadioApi::class.java)
    }

    fun provideRadioRepository(radioApi: RadioApi): RadioRepository {
        return RadioRepositoryImpl(radioApi)
    }
}