package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LyricsInfoEntity(
    @Json(name = "hasAvailableSyncLyrics")
    val hasAvailableSyncLyrics: Boolean,
    @Json(name = "hasAvailableTextLyrics")
    val hasAvailableTextLyrics: Boolean
)