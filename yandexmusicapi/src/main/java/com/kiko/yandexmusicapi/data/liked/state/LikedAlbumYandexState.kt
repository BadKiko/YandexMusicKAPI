package com.kiko.yandexmusicapi.data.liked.state

import com.kiko.yandexmusicapi.data.liked.remote.dto.albums.LikedAlbumEntity
import com.kiko.yandexmusicapi.data.liked.state.LikedPlaylistsYandexState
import com.kiko.yandexmusicapi.data.liked.remote.dto.playlists.LikedPlaylistsEntity

sealed interface LikedAlbumYandexState {
     data class Error(
        val message: String,
    ) : LikedAlbumYandexState

    data object Idle : LikedAlbumYandexState

    data class Success(
        val data: List<LikedAlbumEntity>,
    ) : LikedAlbumYandexState
}
