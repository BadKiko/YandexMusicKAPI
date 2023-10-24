package com.kiko.yandexmusicapi.di

import com.kiko.yandexmusicapi.YandexClient
import com.kiko.yandexmusicapi.data.remote.TokenInterceptor
import com.kiko.yandexmusicapi.constants.YandexMusicConstants
import com.kiko.yandexmusicapi.data.remote.YandexUrlInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideMoshi(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Provides
    fun provideHttpClient(
        yandexClient: YandexClient
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor(yandexClient))
            .addInterceptor(YandexUrlInterceptor(yandexClient))
            .build()
    }

    @Provides
    @Inject
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(YandexMusicConstants.baseUrl)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }
}