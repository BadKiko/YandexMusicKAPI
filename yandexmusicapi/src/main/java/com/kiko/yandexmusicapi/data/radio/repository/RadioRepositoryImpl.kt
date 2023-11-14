package com.kiko.yandexmusicapi.data.radio.repository

import com.kiko.yandexmusicapi.data.radio.remote.api.RadioApi
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestRadioTracksQueue
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNotifyRadio
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.queue.RadioQueueEntity
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
            radioAPI.getNewRadioSession(requestNewRadioSession).request {
                continuation.resume(it)
            }
        }
    }

    override suspend fun getRadioTracksQueue(sessionId: String, requestRadioTracksQueue: RequestRadioTracksQueue): ApiResponse<ResultWrapper<RadioQueueEntity>> {
        return suspendCoroutine { continuation ->
            radioAPI.getRadioTracksQueue(sessionId, requestRadioTracksQueue).request {
                continuation.resume(it)
            }
        }
    }

    override suspend fun notifyStartRadioSession(
        sessionId: String,
        requestNotifyRadio: RequestNotifyRadio
    ) {
        radioAPI.notifyStartRadioSession(sessionId, requestNotifyRadio)
    }

    override suspend fun notifyStartTrackFromRadioSession(
        sessionId: String,
        requestNotifyRadio: RequestNotifyRadio
    ) {
        radioAPI.notifyStartTrack(sessionId, requestNotifyRadio)
    }

    override suspend fun notifySkipTrackFromRadioSession(
        sessionId: String,
        requestNotifyRadio: RequestNotifyRadio
    ) {
        radioAPI.notifySkipTrack(sessionId, requestNotifyRadio)
    }

    override suspend fun notifyEndTrackFromRadioSession(
        sessionId: String,
        requestNotifyRadio: RequestNotifyRadio
    ) {
        radioAPI.notifyEndTrack(sessionId, requestNotifyRadio)
    }
}