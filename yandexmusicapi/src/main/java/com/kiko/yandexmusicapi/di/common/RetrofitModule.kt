package com.kiko.yandexmusicapi.di.common

import com.kiko.yandexmusicapi.YandexMusicClient
import com.kiko.yandexmusicapi.constants.YandexMusicConstants
import com.kiko.yandexmusicapi.data.common.remote.interceptor.TokenInterceptor
import com.kiko.yandexmusicapi.data.common.remote.interceptor.YandexUrlInterceptor
import com.squareup.moshi.Moshi
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
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()).withNullSerialization())
            .build()
    }

    private fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}