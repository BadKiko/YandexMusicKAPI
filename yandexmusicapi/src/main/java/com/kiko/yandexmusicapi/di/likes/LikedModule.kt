package com.kiko.yandexmusicapi.di.likes

import com.kiko.yandexmusicapi.data.liked.remote.api.LikedApi
import com.kiko.yandexmusicapi.data.liked.repository.LikedRepositoryImpl
import com.kiko.yandexmusicapi.domain.likes.repository.LikedRepository
import retrofit2.Retrofit

object LikedModule {
    fun provideLikedApi(retrofit: Retrofit): LikedApi {
        return retrofit.create(LikedApi::class.java)
    }

    fun provideLikedRepository(likedApi: LikedApi): LikedRepository {
        return LikedRepositoryImpl(likedApi)
    }
}