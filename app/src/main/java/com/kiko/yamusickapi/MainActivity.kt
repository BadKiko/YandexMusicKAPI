package com.kiko.yamusickapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.dandan.jsonhandleview.library.JsonViewLayout
import com.google.gson.Gson
import com.kiko.yamusickapi.ui.theme.YandexMusicKotlinAPITheme
import com.kiko.yandexmusicapi.YandexMusicClient
import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.common.AccountYandexState
import com.kiko.yandexmusicapi.data.liked.state.LikedPlaylistsYandexState
import com.kiko.yandexmusicapi.data.common.LikedTracksYandexState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel = MainViewModel()
        setContent {
            YandexMusicKotlinAPITheme {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        Text("Account", style = MaterialTheme.typography.titleLarge)
                    }
                    item {
                        AndroidView(factory = {
                            JsonViewLayout(it)
                        }, update = { jsonView ->
                            mainViewModel.accountData.let { response ->
                                if (response is AccountYandexState.Success) {
                                    jsonView.bindJson(
                                        Gson().toJson(response) ?: "Loading account data"
                                    )
                                }
                            }
                        })
                    }
                    item {
                        Text("Tracks", style = MaterialTheme.typography.titleLarge)
                    }
                    item {
                        AndroidView(factory = {
                            JsonViewLayout(it)
                        }, update = { jsonView ->
                            mainViewModel.likedTracks.let { response ->
                                if (response is LikedTracksYandexState.Success) {
                                    jsonView.bindJson(
                                        Gson().toJson(response) ?: "Loading account data"
                                    )
                                }
                            }
                        })
                    }
                    item {
                        Text("Playlists", style = MaterialTheme.typography.titleLarge)
                    }
                    item {
                        AndroidView(factory = {
                            JsonViewLayout(it)
                        }, update = { jsonView ->
                            mainViewModel.likedPlaylists.let { response ->
                                if (response is LikedPlaylistsYandexState.Success) {
                                    jsonView.bindJson(
                                        Gson().toJson(response) ?: "Loading account data"
                                    )
                                } else if (response is LikedPlaylistsYandexState.Error) {
                                    jsonView.bindJson(
                                        response.message
                                    )
                                }
                            }
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YandexMusicKotlinAPITheme {
        Greeting("Android")
    }
}