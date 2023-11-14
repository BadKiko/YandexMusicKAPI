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
import com.kiko.yandexmusicapi.data.common.RadioSessionYandexState
import com.kiko.yandexmusicapi.data.liked.state.LikedAlbumYandexState
import com.kiko.yandexmusicapi.data.liked.state.LikedArtistsYandexState
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    val yandexMusicClient =
        YandexMusicClient.create(BuildConfig.YANDEX_TOKEN)
    val liked = yandexMusicClient.getLiked()
    val radio = yandexMusicClient.getRadio()

    var accountData by mutableStateOf<AccountYandexState>(AccountYandexState.Idle)

    var likedTracks by mutableStateOf<LikedTracksYandexState>(LikedTracksYandexState.Idle)
    var likedPlaylists by mutableStateOf<LikedPlaylistsYandexState>(LikedPlaylistsYandexState.Idle)
    var likedAlbums by mutableStateOf<LikedAlbumYandexState>(LikedAlbumYandexState.Idle)
    var likedArtists by mutableStateOf<LikedArtistsYandexState>(LikedArtistsYandexState.Idle)

    var onMyWaveRadioSession by mutableStateOf<RadioSessionYandexState>(RadioSessionYandexState.Idle)

    init {
        viewModelScope.launch {
            accountData = yandexMusicClient.getAccount().getAccountStatus()

            accountData.let { response ->
                if (response is AccountYandexState.Success) {
                    likedTracks = liked.getLikedTracks(response.data.account?.uid.toString())
                    likedPlaylists = liked.getLikedPlaylists(response.data.account?.uid.toString())
                    likedAlbums = liked.getLikedAlbums(response.data.account?.uid.toString())
                    likedArtists = liked.getLikedArtists(response.data.account?.uid.toString())

                    onMyWaveRadioSession = radio.getMyWaveRadioSession()
                }
            }
        }
    }
}