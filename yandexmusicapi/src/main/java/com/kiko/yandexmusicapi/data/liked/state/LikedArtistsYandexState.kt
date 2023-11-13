package com.kiko.yandexmusicapi.data.liked.state

import com.kiko.yandexmusicapi.data.liked.remote.dto.artists.LikedArtistsEntity
import com.kiko.yandexmusicapi.data.liked.state.LikedPlaylistsYandexState
import com.kiko.yandexmusicapi.data.liked.remote.dto.playlists.LikedPlaylistsEntity

sealed interface LikedArtistsYandexState {
    data class Error(
        val message: String,
    ) : LikedArtistsYandexState

    data object Idle : LikedArtistsYandexState

    data class Success(
        val data: List<LikedArtistsEntity>,
    ) : LikedArtistsYandexState
}
