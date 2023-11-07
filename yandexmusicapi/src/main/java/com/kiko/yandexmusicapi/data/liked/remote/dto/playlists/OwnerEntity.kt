package com.kiko.yandexmusicapi.data.liked.remote.dto.playlists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OwnerEntity(
    @Json(name = "login")
    val login: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "sex")
    val sex: String,
    @Json(name = "uid")
    val uid: Int,
    @Json(name = "verified")
    val verified: Boolean
)