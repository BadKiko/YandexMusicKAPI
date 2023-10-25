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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kiko.yamusickotlinapi.ui.theme.YandexMusicKotlinAPITheme
import com.kiko.yandexmusicapi.YandexClient
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YandexMusicKotlinAPITheme {
                val yandexClient =
                    YandexClient.create("***REMOVED***-sEk")
                val rememberCoroutine = rememberCoroutineScope()
                LaunchedEffect(true) {
                    rememberCoroutine.launch {
                        yandexClient.getAccountStatus()
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