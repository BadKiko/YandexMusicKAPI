package com.kiko.yamusickapi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiko.yandexmusicapi.YandexMusicClient
import com.kiko.yandexmusicapi.data.common.AccountYandexState
import com.kiko.yandexmusicapi.data.liked.state.LikedPlaylistsYandexState
import com.kiko.yandexmusicapi.data.common.LikedTracksYandexState
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    val yandexMusicClient =
        YandexMusicClient.create("***REMOVED***-sEk")
    val liked = yandexMusicClient.getLiked()

    var accountData by mutableStateOf<AccountYandexState>(AccountYandexState.Idle)
    var likedTracks by mutableStateOf<LikedTracksYandexState>(LikedTracksYandexState.Idle)
    var likedPlaylists by mutableStateOf<LikedPlaylistsYandexState>(LikedPlaylistsYandexState.Idle)

    init {
        viewModelScope.launch {
            accountData = yandexMusicClient.getAccount().getAccountStatus()

            accountData.let { response ->
                if (response is AccountYandexState.Success) {
                    likedTracks = liked.getLikedTracks(response.data.account?.uid.toString())

                    likedPlaylists = liked.getLikedPlaylists(response.data.account?.uid.toString())
                }
            }
        }
    }
}