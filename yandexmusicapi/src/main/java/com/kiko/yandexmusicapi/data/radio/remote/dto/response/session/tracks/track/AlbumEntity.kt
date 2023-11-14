package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track


import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.LabelEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.TrackPositionEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumEntity(
    @Json(name = "artists")
    val artists: List<ArtistEntity>,
    @Json(name = "available")
    val available: Boolean,
    @Json(name = "availableForMobile")
    val availableForMobile: Boolean,
    @Json(name = "availableForOptions")
    val availableForOptions: List<String>,
    @Json(name = "availableForPremiumUsers")
    val availableForPremiumUsers: Boolean,
    @Json(name = "availablePartially")
    val availablePartially: Boolean,
    @Json(name = "bests")
    val bests: List<Int>,
    @Json(name = "contentWarning")
    val contentWarning: String? = null,
    @Json(name = "coverUri")
    val coverUri: String,
    @Json(name = "disclaimers")
    val disclaimers: List<Any>,
    @Json(name = "genre")
    val genre: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "labels")
    val labels: List<LabelEntity>,
    @Json(name = "likesCount")
    val likesCount: Int,
    @Json(name = "metaType")
    val metaType: String,
    @Json(name = "ogImage")
    val ogImage: String,
    @Json(name = "recent")
    val recent: Boolean,
    @Json(name = "releaseDate")
    val releaseDate: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "trackCount")
    val trackCount: Int,
    @Json(name = "trackPosition")
    val trackPosition: TrackPositionEntity,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "veryImportant")
    val veryImportant: Boolean,
    @Json(name = "year")
    val year: Int
)