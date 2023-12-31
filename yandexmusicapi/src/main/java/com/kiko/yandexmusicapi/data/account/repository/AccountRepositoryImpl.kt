package com.kiko.yandexmusicapi.data.account.repository

import com.kiko.yandexmusicapi.data.account.remote.api.AccountApi
import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.common.remote.ResultWrapper
import com.kiko.yandexmusicapi.domain.account.repository.AccountRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.request
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AccountRepositoryImpl (private val accountApi: AccountApi) : AccountRepository {
    override suspend fun getAccountStatus(): ApiResponse<ResultWrapper<StatusEntity>> {
        return suspendCoroutine { continuation ->
            accountApi.getAccountState().request {
                continuation.resume(it)
            }
        }
    }
}