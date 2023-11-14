package com.kiko.yandexmusicapi.data.radio.remote.dto.response.queue


import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.tracks.SequenceEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RadioQueueEntity(
    @Json(name = "batchId")
    val batchId: String,
    @Json(name = "pumpkin")
    val pumpkin: Boolean,
    @Json(name = "unknownSession")
    val unknownSession: Boolean?,
    @Json(name = "sequence")
    val sequence: List<SequenceEntity>
)