package com.kiko.yandexmusicapi.utils

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.math.absoluteValue
import kotlin.time.toKotlinDuration

fun Duration.toLocalTime(): LocalTime {
    return LocalTime.of(
        this.toHours().absoluteValue.toInt(),
        this.toMinutes().absoluteValue.toInt(),
        ((this.toMillis() / 1000) % 60).absoluteValue.toInt(),
    )
}

fun LocalTime.toYandexType(): String {
    val date = LocalDate.now()

    return LocalDateTime.of(date, this).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
}

fun LocalDateTime.toYandexType(): String {
    return this.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
}