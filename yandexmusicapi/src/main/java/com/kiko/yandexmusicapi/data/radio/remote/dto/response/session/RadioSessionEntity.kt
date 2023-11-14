package com.kiko.yandexmusicapi.data.radio.remote.dto.response.session


import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.SequenceEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RadioSessionEntity(
    @Json(name = "acceptedSeeds")
    val acceptedSeeds: List<AcceptedSeedEntity>,
    @Json(name = "batchId")
    val batchId: String,
    @Json(name = "descriptionSeed")
    val descriptionSeed: DescriptionSeedEntity,
    @Json(name = "pumpkin")
    val pumpkin: Boolean,
    @Json(name = "radioSessionId")
    val radioSessionId: String,
    @Json(name = "sequence")
    val sequence: List<SequenceEntity>
)