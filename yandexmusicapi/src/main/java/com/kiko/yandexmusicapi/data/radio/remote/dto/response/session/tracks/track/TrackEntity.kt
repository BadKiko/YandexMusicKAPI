package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track


import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track.AlbumEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track.ArtistEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track.DerivedColorsEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track.FadeEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track.LyricsInfoEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.MajorEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.track.R128Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackEntity(
    @Json(name = "albums")
    val albums: List<AlbumEntity>,
    @Json(name = "artists")
    val artists: List<ArtistEntity>,
    @Json(name = "available")
    val available: Boolean,
    @Json(name = "availableForOptions")
    val availableForOptions: List<String>,
    @Json(name = "availableForPremiumUsers")
    val availableForPremiumUsers: Boolean,
    @Json(name = "availableFullWithoutPermission")
    val availableFullWithoutPermission: Boolean,
    @Json(name = "contentWarning")
    val contentWarning: String? = null,
    @Json(name = "coverUri")
    val coverUri: String,
    @Json(name = "derivedColors")
    val derivedColors: DerivedColorsEntity,
    @Json(name = "disclaimers")
    val disclaimers: List<Any>,
    @Json(name = "durationMs")
    val durationMs: Int,
    @Json(name = "fade")
    val fade: FadeEntity,
    @Json(name = "fileSize")
    val fileSize: Int,
    @Json(name = "id")
    val id: String,
    @Json(name = "lyricsAvailable")
    val lyricsAvailable: Boolean,
    @Json(name = "lyricsInfo")
    val lyricsInfo: LyricsInfoEntity,
    @Json(name = "major")
    val major: MajorEntity,
    @Json(name = "ogImage")
    val ogImage: String,
    @Json(name = "previewDurationMs")
    val previewDurationMs: Int,
    @Json(name = "r128")
    val r128: R128Entity,
    @Json(name = "realId")
    val realId: String,
    @Json(name = "rememberPosition")
    val rememberPosition: Boolean,
    @Json(name = "storageDir")
    val storageDir: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "trackSharingFlag")
    val trackSharingFlag: String,
    @Json(name = "trackSource")
    val trackSource: String,
    @Json(name = "type")
    val type: String
)