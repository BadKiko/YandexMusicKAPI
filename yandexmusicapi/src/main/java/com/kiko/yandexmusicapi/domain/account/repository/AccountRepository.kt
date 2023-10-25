package com.kiko.yandexmusicapi.domain.account.repository

import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun getAccountStatus(): Flow<ApiResponse<ResultWrapper<StatusEntity>>>
}