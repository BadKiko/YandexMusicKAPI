package com.kiko.yandexmusicapi.data.radio.remote.dto.request

import android.os.Build
import androidx.annotation.RequiresApi
import com.kiko.yandexmusicapi.utils.toYandexType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


@JsonClass(generateAdapter = true)
data class RequestNotifyRadio(
    @Json(name = "batchId")
    val batchId: String,
    @Json(name = "event")
    val event: EventEntity
)

@JsonClass(generateAdapter = true)
data class EventEntity(
    @Json(name = "timestamp")
    val timestamp: String,
    @Json(name = "totalPlayedSeconds")
    val totalPlayedSeconds: String? = null,
    @Json(name = "trackId")
    val trackId: String,
    @Json(name = "type")
    val type: String?
) {

    companion object {
        /**
         * Сгенерировать фидбек для Yandex.Music Radio (для трека)
         */
        fun generateEvent(
            currentTrackId: Int,
            playedSeconds: String
        ): EventEntity {
            val timestamp = LocalDateTime.now().toYandexType()
            return EventEntity(timestamp, playedSeconds, currentTrackId.toString(), null)
        }

        /**
         * Сгенерировать фидбек для Yandex.Music Radio (для радио сессии)
         */
        fun generateEvent(
            currentTrackId: Int,
        ): EventEntity {
            val timestamp = LocalDateTime.now().toYandexType()
            return EventEntity(timestamp, null, currentTrackId.toString(), null)
        }
    }
}

enum class RadioEvent(val event: String) {
    START_RADIO("radioStarted"),
    START_TRACK("trackStarted"),
    SKIP_TRACK("skip"),
    END_TRACK("trackFinished")
}