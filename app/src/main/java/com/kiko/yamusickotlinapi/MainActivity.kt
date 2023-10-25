package com.kiko.yamusickotlinapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kiko.yamusickotlinapi.ui.theme.YandexMusicKotlinAPITheme
import com.kiko.yandexmusicapi.YandexClient
import com.kiko.yandexmusicapi.data.account.remote.dto.AccountEntity
import com.kiko.yandexmusicapi.data.account.remote.dto.StatusEntity
import com.kiko.yandexmusicapi.data.common.StatusEntityYandexState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YandexMusicKotlinAPITheme {
                var accountStatus: MutableState<StatusEntity?> = remember { mutableStateOf(null) }

                val yandexClient =
                    YandexClient.create("***REMOVED***-sEk")
                val rememberCoroutine = rememberCoroutineScope()
                LaunchedEffect(true) {
                    rememberCoroutine.launch {
                        when (val yandex = yandexClient.getAccountStatus()) {
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