package com.kiko.yandexmusicapi.data.liked.remote.dto.playlists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CaseFormsEntity(
    @Json(name = "accusative")
    val accusative: String,
    @Json(name = "dative")
    val dative: String,
    @Json(name = "genitive")
    val genitive: String,
    @Json(name = "instrumental")
    val instrumental: String,
    @Json(name = "nominative")
    val nominative: String,
    @Json(name = "prepositional")
    val prepositional: String
)