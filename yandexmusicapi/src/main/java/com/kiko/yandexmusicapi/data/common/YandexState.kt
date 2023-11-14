package com.kiko.yandexmusicapi.data.common

import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.playlists.LikedPlaylistsEntity
import com.kiko.yandexmusicapi.data.liked.remote.dto.tracks.LikedTracksEntity
import com.kiko.yandexmusicapi.data.radio.remote.dto.response.session.RadioSessionEntity
import com.skydoves.sealedx.core.Extensive
import com.skydoves.sealedx.core.annotations.ExtensiveModel
import com.skydoves.sealedx.core.annotations.ExtensiveSealed

@ExtensiveSealed(
    models = [
        ExtensiveModel(StatusEntity::class, "Account"),
        ExtensiveModel(LikedTracksEntity::class,"LikedTracks"),
        ExtensiveModel(RadioSessionEntity::class,"RadioSession")
    ]
)
/**
 * Состояния возвращения результата
 */
sealed interface YandexState {
    data class Success(val data: Extensive) : YandexState
    data class Error(val message: String) : YandexState
    data object Idle : YandexState
}