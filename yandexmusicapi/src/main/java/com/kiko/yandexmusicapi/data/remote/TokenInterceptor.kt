package com.kiko.psychoarticles.di.intercepter

import android.content.SharedPreferences
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class TokenInterceptor @Inject constructor() :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization", "OAuth ${it.data.token}")
            .build()

        return chain.proceed(newRequest)
    }
}
