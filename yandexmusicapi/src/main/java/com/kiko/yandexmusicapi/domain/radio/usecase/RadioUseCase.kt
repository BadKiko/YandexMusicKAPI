package com.kiko.yandexmusicapi.domain.radio.usecase

import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestRadioTracksQueue
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNotifyRadio
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.queue.RadioQueueEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.common.remote.ResultWrapper
import com.kiko.yandexmusicapi.domain.radio.repository.RadioRepository
import com.skydoves.sandwich.ApiResponse

class RadioUseCase(private val radioRepository: RadioRepository) {
    suspend fun getNewUserRadioSession(requestNewRadioSession: RequestNewRadioSession): ApiResponse<ResultWrapper<RadioSessionEntity>> {
        return radioRepository.getNewUserRadioSession(requestNewRadioSession)
    }

    suspend fun getRadioTracksQueue(sessionId: String, requestRadioTracksQueue: RequestRadioTracksQueue)  : ApiResponse<ResultWrapper<RadioQueueEntity>> {
        return radioRepository.getRadioTracksQueue(sessionId, requestRadioTracksQueue)
    }

    suspend fun notifyStartRadioSession(sessionId: String, requestNotifyRadio: RequestNotifyRadio) {
        return radioRepository.notifyStartRadioSession(sessionId, requestNotifyRadio)
    }

    suspend fun notifyStartTrackFromRadioSession(sessionId: String, requestNotifyRadio: RequestNotifyRadio){
        return radioRepository.notifyStartTrackFromRadioSession(sessionId, requestNotifyRadio)
    }

    suspend fun notifySkipTrackFromRadioSession(sessionId: String, requestNotifyRadio: RequestNotifyRadio) {
        return radioRepository.notifySkipTrackFromRadioSession(sessionId, requestNotifyRadio)
    }

    suspend fun notifyEndTrackFromRadioSession(sessionId: String, requestNotifyRadio: RequestNotifyRadio){
        return radioRepository.notifyEndTrackFromRadioSession(sessionId, requestNotifyRadio)
    }

}