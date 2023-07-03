package com.ajailani.musicplayer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ajailani.musicplayer.data.service.MusicPlaybackService
import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.ui.component.MusicMiniPlaybackCard
import com.ajailani.musicplayer.ui.navigation.Navigation
import com.ajailani.musicplayer.ui.theme.MusicPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box {
                        val navController = rememberNavController()

                        Navigation(navController)

                        MusicMiniPlaybackCard(
                            modifier = Modifier
                                .padding(10.dp)
                                .align(Alignment.BottomCenter),
                            music = Music(
                                id = "1",
                                title = "Test",
                                artist = "Someone",
                                source = "",
                                image = "https://storage.googleapis.com/uamp/The_Kyoto_Connection_-_Wake_Up/art.jpg"
                            )
                        )
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        stopService(Intent(this, MusicPlaybackService::class.java))
    }
}