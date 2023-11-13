package com.kiko.yandexmusicapi.data.liked.remote.dto.artists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountsEntity(
    @Json(name = "alsoAlbums")
    val alsoAlbums: Int,
    @Json(name = "alsoTracks")
    val alsoTracks: Int,
    @Json(name = "directAlbums")
    val directAlbums: Int,
    @Json(name = "tracks")
    val tracks: Int
)