package com.kiko.yandexmusicapi.di

import com.kiko.yandexmusicapi.YandexClient
import com.kiko.yandexmusicapi.constants.YandexMusicConstants
import com.kiko.yandexmusicapi.data.remote.interceptor.TokenInterceptor
import com.kiko.yandexmusicapi.data.remote.interceptor.YandexUrlInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitModule {

    fun provideHttpClient(
        yandexClient: YandexClient
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor(yandexClient))
            .addInterceptor(YandexUrlInterceptor(yandexClient))
            .build()
    }

    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(YandexMusicConstants.baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}