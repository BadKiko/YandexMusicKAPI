package com.kiko.yandexmusicapi.data.remote.interceptor

import com.kiko.yandexmusicapi.YandexMusicClient
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.Response
import java.io.IOException

/**
 * Интерцептор который вставляет меняет url адрес если под Yandex Client
 */
class YandexUrlInterceptor(private val yandexMusicClient: YandexMusicClient) :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val originalRequest = chain.request()

        val newBaseUrl = yandexMusicClient.baseUrl

        val newRequest = originalRequest.newBuilder()
            .url("$newBaseUrl/${originalRequest.url.pathSegments.joinToString("/")}")
            .build()

        return chain.proceed(newRequest)
    }
}
