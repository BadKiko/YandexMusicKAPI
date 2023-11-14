package com.kiko.yandexmusicapi.domain.radio.repository

import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestRadioTracksQueue
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNotifyRadio
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.queue.RadioQueueEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import com.skydoves.sandwich.ApiResponse

interface RadioRepository {
    suspend fun getNewUserRadioSession(requestNewRadioSession: RequestNewRadioSession) : ApiResponse<ResultWrapper<RadioSessionEntity>>
    suspend fun getRadioTracksQueue(sessionId: String, requestRadioTracksQueue: RequestRadioTracksQueue) : ApiResponse<ResultWrapper<RadioQueueEntity>>
    fun notifyStartRadioSession(sessionId: String, requestNotifyRadio: RequestNotifyRadio)
    fun notifyStartTrackFromRadioSession(sessionId: String, requestNotifyRadio: RequestNotifyRadio)
    fun notifySkipTrackFromRadioSession(sessionId: String, requestNotifyRadio: RequestNotifyRadio)
    fun notifyEndTrackFromRadioSession(sessionId: String, requestNotifyRadio: RequestNotifyRadio)
}