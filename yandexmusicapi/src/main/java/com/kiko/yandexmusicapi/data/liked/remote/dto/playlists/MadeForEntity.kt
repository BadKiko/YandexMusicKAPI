package com.kiko.yandexmusicapi.data.liked.remote.dto.playlists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MadeForEntity(
    @Json(name = "caseForms")
    val caseFormsEntity: CaseFormsEntity,
    @Json(name = "userInfo")
    val userInfo: UserInfo
)