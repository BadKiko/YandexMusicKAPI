package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track


import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.CoverEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistEntity(
    @Json(name = "composer")
    val composer: Boolean,
    @Json(name = "cover")
    val cover: CoverEntity,
    @Json(name = "disclaimers")
    val disclaimers: List<Any>,
    @Json(name = "genres")
    val genres: List<Any>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "various")
    val various: Boolean
)