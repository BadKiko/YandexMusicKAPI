package com.kiko.yandexmusicapi.data.liked.state

import com.kiko.yandexmusicapi.data.liked.state.LikedPlaylistsYandexState
import com.kiko.yandexmusicapi.data.liked.remote.dto.playlists.LikedPlaylistsEntity

sealed interface LikedPlaylistsYandexState {
     data class Error(
        val message: String,
    ) : LikedPlaylistsYandexState

    data object Idle : LikedPlaylistsYandexState

    data class Success(
        val data: List<LikedPlaylistsEntity>,
    ) : LikedPlaylistsYandexState
}
