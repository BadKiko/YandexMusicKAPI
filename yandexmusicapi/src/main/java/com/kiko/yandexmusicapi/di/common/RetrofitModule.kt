package com.kiko.yandexmusicapi.di.common

import com.kiko.yandexmusicapi.YandexMusicClient
import com.kiko.yandexmusicapi.constants.YandexMusicConstants
import com.kiko.yandexmusicapi.data.remote.interceptor.TokenInterceptor
import com.kiko.yandexmusicapi.data.remote.interceptor.YandexUrlInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitModule {

    fun provideHttpClient(
        yandexMusicClient: YandexMusicClient
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor(yandexMusicClient))
            .addInterceptor(YandexUrlInterceptor(yandexMusicClient))
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