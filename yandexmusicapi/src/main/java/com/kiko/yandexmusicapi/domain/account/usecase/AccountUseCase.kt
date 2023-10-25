package com.kiko.yandexmusicapi.domain.account.usecase

import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import com.kiko.yandexmusicapi.domain.account.repository.AccountRepository
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow

class AccountUseCase (private val accountRepository: AccountRepository) {
    fun getStatus(): Flow<ApiResponse<ResultWrapper<StatusEntity>>> {
        return accountRepository.getAccountStatus()
    }
}