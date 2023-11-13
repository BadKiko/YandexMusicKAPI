package com.kiko.yandexmusicapi.data.liked.remote.dto.artists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LikedArtistsEntity(
    @Json(name = "available")
    val available: Boolean,
    @Json(name = "composer")
    val composer: Boolean,
    @Json(name = "counts")
    val counts: CountsEntity,
    @Json(name = "cover")
    val cover: CoverEntity,
    @Json(name = "disclaimers")
    val disclaimers: List<DescriptionEntity>,
    @Json(name = "genres")
    val genres: List<String>,
    @Json(name = "id")
    val id: String,
    @Json(name = "links")
    val links: List<LinkEntity>,
    @Json(name = "name")
    val name: String,
    @Json(name = "noPicturesFromSearch")
    val noPicturesFromSearch: Boolean? = null,
    @Json(name = "ogImage")
    val ogImage: String,
    @Json(name = "ratings")
    val ratings: RatingsEntity,
    @Json(name = "ticketsAvailable")
    val ticketsAvailable: Boolean,
    @Json(name = "various")
    val various: Boolean
)