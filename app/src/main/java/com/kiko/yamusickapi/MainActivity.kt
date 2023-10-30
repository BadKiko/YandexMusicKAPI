package com.kiko.yamusickapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kiko.yamusickapi.ui.theme.YandexMusicKotlinAPITheme
import com.kiko.yandexmusicapi.YandexMusicClient
import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.common.StatusEntityYandexState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YandexMusicKotlinAPITheme {
                var accountStatus: MutableState<StatusEntity?> = remember { mutableStateOf(null) }

                val yandexMusicClient =
                    YandexMusicClient.create("***REMOVED***-sEk")
                val rememberCoroutine = rememberCoroutineScope()
                LaunchedEffect(true) {
                    rememberCoroutine.launch {
                        when (val yandex = yandexMusicClient.getAccountStatus()) {
                            is StatusEntityYandexState.Error -> TODO()
                            is StatusEntityYandexState.Success -> {
                                accountStatus.value = yandex.data
                            }
                        }
                    }
                }

                Text(accountStatus.value?.account?.fullName ?: "Cock")
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