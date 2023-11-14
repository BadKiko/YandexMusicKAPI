package com.kiko.yandexmusicapi.data.radio.remote.api

import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.queue.RadioQueueEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path


/**
 * Endpoints для взаимодействия с ра
 */
interface RadioApi {
    /**
     * Создаем сессию радио
     */
    @POST("rotor/session/new")
    fun startNewRadioSession(@Body requsetNewRadioSession: RequestNewRadioSession) : Call<ResultWrapper<RadioSessionEntity>>

    @POST("rotor/session/{sessionId}/feedback")
    fun startNewRadioSession(@Path("sessionId") sessionId: String,@Body requsetNewRadioSession: RequestNewRadioSession) : Call<ResultWrapper<RadioSessionEntity>>

    @POST("rotor/session/{sessionId}/feedback")
    fun startRadioSession(@Path("sessionId") sessionId: String,@Body requsetNewRadioSession: RequestNewRadioSession) : Call<ResultWrapper<Any>>

    @POST("rotor/session/{sessionId}/feedback")
    fun startTrackFromRadioSession(@Path("sessionId") sessionId: String,@Body requsetNewRadioSession: RequestNewRadioSession) : Call<ResultWrapper<Any>>

    @POST("rotor/session/{sessionId}/feedback")
    fun skipTrackFromRadioSession(@Path("sessionId") sessionId: String,@Body requsetNewRadioSession: RequestNewRadioSession) : Call<ResultWrapper<Any>>

    @POST("rotor/session/{sessionId}/feedback")
    fun endTrackFromRadioSession(@Path("sessionId") sessionId: String,@Body requsetNewRadioSession: RequestNewRadioSession) : Call<ResultWrapper<Any>>

    @POST("rotor/session/{sessionId}/tracks")
    fun getNextTracksFromRadioSession(@Path("sessionId") sessionId: String,@Body requsetNewRadioSession: RequestNewRadioSession) : Call<ResultWrapper<RadioQueueEntity>>
}