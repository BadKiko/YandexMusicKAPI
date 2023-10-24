package com.kiko.yandexmusicapi.data.remote

import com.kiko.yandexmusicapi.YandexClient
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class YandexUrlInterceptor(private val yandexClient: YandexClient) :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val originalRequest = chain.request()

        val newBaseUrl = yandexClient.baseUrl

        val newRequest = originalRequest.newBuilder()
            .url(newBaseUrl + originalRequest.url.pathSegments)
            .build()

        return chain.proceed(newRequest)
    }
}
