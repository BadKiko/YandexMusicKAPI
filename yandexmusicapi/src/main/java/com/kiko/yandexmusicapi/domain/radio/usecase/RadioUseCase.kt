package com.kiko.yandexmusicapi.domain.radio.usecase

import com.kiko.yandexmusicapi.data.liked.remote.dto.artists.LikedArtistsEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.request.RequestNewRadioSession
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.kiko.yandexmusicapi.data.remote.ResultWrapper
import com.kiko.yandexmusicapi.domain.radio.repository.RadioRepository
import com.skydoves.sandwich.ApiResponse

class RadioUseCase(private val radioRepository: RadioRepository) {
    suspend fun getNewUserRadioSession(requestNewRadioSession: RequestNewRadioSession): ApiResponse<ResultWrapper<RadioSessionEntity>> {
        return radioRepository.getNewUserRadioSession(requestNewRadioSession)
    }
}