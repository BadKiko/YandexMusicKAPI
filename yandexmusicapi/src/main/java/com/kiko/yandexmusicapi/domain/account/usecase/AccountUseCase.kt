package com.kiko.yandexmusicapi.domain.account.usecase

import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.common.remote.ResultWrapper
import com.kiko.yandexmusicapi.domain.account.repository.AccountRepository
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow

class AccountUseCase (private val accountRepository: AccountRepository) {
    suspend fun getStatus(): ApiResponse<ResultWrapper<StatusEntity>> {
        return accountRepository.getAccountStatus()
    }
}