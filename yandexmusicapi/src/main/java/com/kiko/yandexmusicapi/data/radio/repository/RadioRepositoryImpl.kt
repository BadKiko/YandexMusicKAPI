package com.kiko.yandexmusicapi.data.radio.repository

import com.kiko.yandexmusicapi.data.radio.remote.api.RadioApi
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RadioEvent
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestRadioTracksQueue
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNotifyRadio
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.queue.RadioQueueEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.common.remote.ResultWrapper
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

    override suspend fun getRadioTracksQueue(
        sessionId: String,
        requestRadioTracksQueue: RequestRadioTracksQueue
    ): ApiResponse<ResultWrapper<RadioQueueEntity>> {
        return suspendCoroutine { continuation ->
            radioAPI.getRadioTracksQueue(sessionId, requestRadioTracksQueue).request {
                continuation.resume(it)
            }
        }
    }

    override fun notifyStartRadioSession(
        sessionId: String,
        requestNotifyRadio: RequestNotifyRadio
    ) {
        val request = requestNotifyRadio.copy(
            event = requestNotifyRadio.event.copy(type = RadioEvent.START_RADIO.event)
        )

        radioAPI.notifyStartRadioSession(sessionId, request)
    }

    override fun notifyStartTrackFromRadioSession(
        sessionId: String,
        requestNotifyRadio: RequestNotifyRadio
    ) {
        val request = requestNotifyRadio.copy(
            event = requestNotifyRadio.event.copy(type = RadioEvent.START_TRACK.event)
        )

        radioAPI.notifyStartTrack(sessionId, request)
    }

    override fun notifySkipTrackFromRadioSession(
        sessionId: String,
        requestNotifyRadio: RequestNotifyRadio
    ) {
        val request = requestNotifyRadio.copy(
            event = requestNotifyRadio.event.copy(type = RadioEvent.SKIP_TRACK.event)
        )

        radioAPI.notifySkipTrack(sessionId, request)
    }

    override fun notifyEndTrackFromRadioSession(
        sessionId: String,
        requestNotifyRadio: RequestNotifyRadio
    ) {
        val request = requestNotifyRadio.copy(
            event = requestNotifyRadio.event.copy(type = RadioEvent.END_TRACK.event)
        )

        radioAPI.notifyEndTrack(sessionId, request)
    }
}