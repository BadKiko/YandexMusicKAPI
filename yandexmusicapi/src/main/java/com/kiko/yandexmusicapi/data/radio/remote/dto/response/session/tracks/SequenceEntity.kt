package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks


import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track.TrackEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SequenceEntity(
    @Json(name = "liked")
    val liked: Boolean,
    @Json(name = "track")
    val track: TrackEntity,
    @Json(name = "trackParameters")
    val trackParameters: TrackParametersEntity,
    @Json(name = "type")
    val type: String
)