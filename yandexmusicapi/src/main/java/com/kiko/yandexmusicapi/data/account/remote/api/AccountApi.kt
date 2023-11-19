package com.kiko.yandexmusicapi.data.account.remote.api

import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.common.remote.ResultWrapper
import retrofit2.Call
import retrofit2.http.GET

/**
 * Endpoints для взаимодействия с аккаунтом
 */
interface AccountApi {
    @GET("account/status")
    fun getAccountState(): Call<ResultWrapper<StatusEntity>>
}