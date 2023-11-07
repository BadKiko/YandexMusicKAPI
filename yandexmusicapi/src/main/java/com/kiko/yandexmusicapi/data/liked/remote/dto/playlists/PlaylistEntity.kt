package com.kiko.yandexmusicapi.data.liked.remote.dto.playlists


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Основной класс плейлистов
 *
 * @param animatedCoverUri - URL анимированной обложки плейлиста.
 * @param available - указывает, доступен ли плейлист для прослушивания.
 * @param backgroundImageUrl - URL фонового изображения плейлиста.
 * @param backgroundVideoUrl - URL фонового видео плейлиста.
 * @param collective - указывает, является ли плейлист коллективным.
 * @param coverEntity - объект, описывающий обложку плейлиста.
 * @param coverWithoutTextEntity - объект, описывающий обложку плейлиста без текста.
 * @param created - дата создания плейлиста.
 * @param customWaveEntity - объект, описывающий пользовательскую волну плейлиста.
 * @param description - описание плейлиста.
 * @param descriptionFormatted - описание плейлиста в форматированном виде.
 * @param durationMs - продолжительность плейлиста в миллисекундах.
 * @param everPlayed - указывает, был ли плейлист когда-либо прослушан.
 * @param generatedPlaylistType - тип сгенерированного плейлиста.
 * @param idForFrom - ID плейлиста для использования в качестве источника для других плейлистов.
 * @param isBanner - указывает, является ли плейлист баннером.
 * @param isPremiere - указывает, является ли плейлист премьерным.
 * @param kind - тип плейлиста.
 * @param likesCount - количество лайков плейлиста.
 * @param madeForEntity - объект, описывающий, для кого был создан плейлист.
 * @param modified - дата последнего изменения плейлиста.
 * @param ogImage - URL изображения для Open Graph.
 * @param ogTitle - заголовок для Open Graph.
 * @param ownerEntity - объект, описывающий владельца плейлиста.
 * @param playlistUuid - UUID плейлиста.
 * @param revision - ревизия плейлиста.
 * @param snapshot - снэпшот плейлиста.
 * @param tags - список тегов плейлиста.
 * @param title - заголовок плейлиста.
 * @param trackCount - количество треков в плейлисте.
 * @param uid - уникальный идентификатор плейлиста.
 * @param urlPart - часть URL, соответствующая плейлисту.
 * @param visibility - видимость плейлиста.
 */
@JsonClass(generateAdapter = true)
data class PlaylistEntity(
    @Json(name = "animatedCoverUri")
    val animatedCoverUri: String?,
    @Json(name = "available")
    val available: Boolean,
    @Json(name = "backgroundImageUrl")
    val backgroundImageUrl: String?,
    @Json(name = "backgroundVideoUrl")
    val backgroundVideoUrl: String?,
    @Json(name = "collective")
    val collective: Boolean,
    @Json(name = "cover")
    val coverEntity: CoverEntity,
    @Json(name = "coverWithoutText")
    val coverWithoutTextEntity: CoverWithoutTextEntity?,
    @Json(name = "created")
    val created: String,
    @Json(name = "customWave")
    val customWaveEntity: CustomWaveEntity?,
    @Json(name = "description")
    val description: String,
    @Json(name = "descriptionFormatted")
    val descriptionFormatted: String,
    @Json(name = "durationMs")
    val durationMs: Int,
    @Json(name = "everPlayed")
    val everPlayed: Boolean?,
    @Json(name = "generatedPlaylistType")
    val generatedPlaylistType: String?,
    @Json(name = "idForFrom")
    val idForFrom: String?,
    @Json(name = "isBanner")
    val isBanner: Boolean,
    @Json(name = "isPremiere")
    val isPremiere: Boolean,
    @Json(name = "kind")
    val kind: Int,
    @Json(name = "likesCount")
    val likesCount: Int,
    @Json(name = "madeFor")
    val madeForEntity: MadeForEntity?,
    @Json(name = "modified")
    val modified: String,
    @Json(name = "ogImage")
    val ogImage: String,
    @Json(name = "ogTitle")
    val ogTitle: String?,
    @Json(name = "owner")
    val ownerEntity: OwnerEntity,
    @Json(name = "playlistUuid")
    val playlistUuid: String,
    @Json(name = "revision")
    val revision: Int,
    @Json(name = "snapshot")
    val snapshot: Int,
    @Json(name = "tags")
    val tags: List<Tag>,
    @Json(name = "title")
    val title: String,
    @Json(name = "trackCount")
    val trackCount: Int,
    @Json(name = "uid")
    val uid: Int,
    @Json(name = "urlPart")
    val urlPart: String?,
    @Json(name = "visibility")
    val visibility: String
)