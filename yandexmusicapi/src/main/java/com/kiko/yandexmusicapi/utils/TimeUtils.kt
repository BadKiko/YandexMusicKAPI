package com.kiko.yandexmusicapi.utils

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.math.absoluteValue
import kotlin.time.toKotlinDuration

fun Duration.toLocalTime(): LocalTime {
    val duration = this.toKotlinDuration()
    return LocalTime.of(
        duration.inWholeHours.absoluteValue.toInt(),
        duration.inWholeMinutes.absoluteValue.toInt(),
        duration.inWholeSeconds.absoluteValue.toInt(),
    )
}

fun LocalTime.toYandexType(): String {
    val date = LocalDate.now()

    return LocalDateTime.of(date, this).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
}

fun LocalDateTime.toYandexType(): String {
    return this.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
}