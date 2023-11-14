package com.kiko.yandexmusicapi.domain.radio.repository

import com.kiko.yandexmusicapi.data.liked.remote.dto.tracks.LikedTracksEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import com.skydoves.sandwich.ApiResponse

interface RadioRepository {
    suspend fun getNewUserRadioSession(requestNewRadioSession: RequestNewRadioSession) : ApiResponse<ResultWrapper<RadioSessionEntity>>
    suspend fun getNextTracksFromRadioSession(requestNewRadioSession: RequestNewRadioSession) : ApiResponse<ResultWrapper<RadioSessionEntity>>

    suspend fun notifyNewRadioSession(requestNewRadioSession: RequestNewRadioSession) : ApiResponse<ResultWrapper<RadioSessionEntity>>
    suspend fun notifyStartRadioSession(requestNewRadioSession: RequestNewRadioSession) : ApiResponse<ResultWrapper<RadioSessionEntity>>
    suspend fun notifyStartTrackFromRadioSession(requestNewRadioSession: RequestNewRadioSession) : ApiResponse<ResultWrapper<RadioSessionEntity>>
    suspend fun notifySkipTrackFromRadioSession(requestNewRadioSession: RequestNewRadioSession) : ApiResponse<ResultWrapper<RadioSessionEntity>>
    suspend fun notifyEndTrackFromRadioSession(requestNewRadioSession: RequestNewRadioSession) : ApiResponse<ResultWrapper<RadioSessionEntity>>
}