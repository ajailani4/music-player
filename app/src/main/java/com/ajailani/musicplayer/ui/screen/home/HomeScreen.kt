package com.ajailani.musicplayer.ui.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.ui.screen.home.component.MusicItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "MusicPlayer") }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(5) {
                MusicItem(
                    music = Music(
                        id = "1",
                        title = "Test",
                        artist = "Someone",
                        source = "",
                        image = "https://storage.googleapis.com/uamp/Spatial%20Audio/Marching%20band.jpg"
                    ),
                    onClick = {}
                )
            }
        }
    }
}