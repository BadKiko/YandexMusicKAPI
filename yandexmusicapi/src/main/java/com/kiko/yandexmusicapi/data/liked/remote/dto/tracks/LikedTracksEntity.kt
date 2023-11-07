package com.kiko.yandexmusicapi.data.liked.remote.dto.tracks


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Wrapper для получения треков
 */
@JsonClass(generateAdapter = true)
data class LikedTracksEntity(
    @Json(name = "library")
    val library: LikedTrackEntity
)