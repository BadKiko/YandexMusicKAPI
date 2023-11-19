package com.kiko.yandexmusicapi.data.radio.remote.api

import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestRadioTracksQueue
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNotifyRadio
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.queue.RadioQueueEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.common.remote.ResultWrapper
import okhttp3.ResponseBody
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
    fun getNewRadioSession(@Body requestNewRadioSession: RequestNewRadioSession) : Call<ResultWrapper<RadioSessionEntity>>

    /**
     * Получение следующей последовательности треков
     */
    @POST("rotor/session/{sessionId}/tracks")
    fun getRadioTracksQueue(@Path("sessionId") sessionId: String, @Body requestNewRadioSession: RequestRadioTracksQueue) : Call<ResultWrapper<RadioQueueEntity>>

    /**
     * Уведомить сессию о начале радио
     */
    @POST("rotor/session/{sessionId}/feedback")
    fun notifyStartRadioSession(@Path("sessionId") sessionId: String, @Body requestNotifyRadio: RequestNotifyRadio) : Call<ResponseBody>

    /**
     * Уведомить сессию о запуске трека
     */
    @POST("rotor/session/{sessionId}/feedback")
    fun notifyStartTrack(@Path("sessionId") sessionId: String,  @Body requestNotifyRadio: RequestNotifyRadio) : Call<ResponseBody>

    /**
     * Уведомить сессию о пропуске трека
     */
    @POST("rotor/session/{sessionId}/feedback")
    fun notifySkipTrack(@Path("sessionId") sessionId: String,  @Body requestNotifyRadio: RequestNotifyRadio) : Call<ResponseBody>

    /**
     * Уведомить сессию о конце трека
     */
    @POST("rotor/session/{sessionId}/feedback")
    fun notifyEndTrack(@Path("sessionId") sessionId: String,  @Body requestNotifyRadio: RequestNotifyRadio) : Call<ResponseBody>
}