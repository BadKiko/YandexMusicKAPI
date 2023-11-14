package com.kiko.yandexmusicapi.data.radio.repository

import com.kiko.yandexmusicapi.data.radio.remote.api.RadioApi
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import com.kiko.yandexmusicapi.domain.radio.repository.RadioRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.request
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RadioRepositoryImpl(private val radioAPI: RadioApi) : RadioRepository {
    override suspend fun getNewUserRadioSession(requestNewRadioSession: RequestNewRadioSession): ApiResponse<ResultWrapper<RadioSessionEntity>> {
        return suspendCoroutine { continuation ->
            radioAPI.startNewRadioSession(requestNewRadioSession).request {
                continuation.resume(it)
            }
        }
    }
}