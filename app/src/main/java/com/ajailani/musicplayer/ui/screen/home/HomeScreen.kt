package com.ajailani.musicplayer.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.ui.screen.home.component.MusicItem
import com.ajailani.musicplayer.ui.screen.home.component.MusicMiniPlaybackCard
import com.ajailani.musicplayer.ui.shared_component.MusicPlaybackUiState
import com.ajailani.musicplayer.ui.shared_component.SharedViewModel
import com.ajailani.musicplayer.util.PlayerState
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onEvent: (HomeEvent) -> Unit,
    homeUiState: HomeUiState,
    musicPlaybackUiState: MusicPlaybackUiState
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text(text = "MusicPlayer") }
            )
        }
    ) { innerPadding ->
        homeUiState.run {
            when {
                loading == true -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                loading == false && errorMessage == null -> {
                    if (musics != null) {
                        Box {
                            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                                items(musics) {
                                    MusicItem(
                                        music = it,
                                        onClick = {
                                            onEvent(HomeEvent.OnMusicSelected(it))
                                            onEvent(HomeEvent.PlayMusic)
                                        }
                                    )
                                }
                            }

                            selectedMusic?.let {
                                musicPlaybackUiState.playerState?.let { playerState ->
                                    MusicMiniPlaybackCard(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .align(Alignment.BottomCenter),
                                        music = it,
                                        playerState = playerState,
                                        onResumeClicked = { onEvent(HomeEvent.ResumeMusic) },
                                        onPauseClicked = { onEvent(HomeEvent.PauseMusic) }
                                    )
                                }
                            }
                        }
                    }
                }

                errorMessage != null -> {
                    LaunchedEffect(snackbarHostState) {
                        snackbarHostState.showSnackbar(errorMessage)
                    }
                }
            }
        }
    }
}