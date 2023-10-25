package com.kiko.yandexmusicapi.data.remote.interceptor

import com.kiko.yandexmusicapi.YandexClient
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


/**
 * Интерцептор который вставляет токен в любой запрос
 */
class TokenInterceptor(private val yandexClient: YandexClient) :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization", "OAuth ${yandexClient.token}")
            .build()

        return chain.proceed(newRequest)
    }
}
