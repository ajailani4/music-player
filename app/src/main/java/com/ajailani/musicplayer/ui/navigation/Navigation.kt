package com.ajailani.musicplayer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ajailani.musicplayer.ui.screen.home.HomeScreen
import com.ajailani.musicplayer.ui.screen.home.HomeViewModel
import com.ajailani.musicplayer.ui.screen.music_player.MusicPlayerScreen
import com.ajailani.musicplayer.ui.shared_component.SharedViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val musicPlaybackUiState = sharedViewModel.musicPlaybackUiState

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = koinViewModel()

            HomeScreen(
                onEvent = homeViewModel::onEvent,
                homeUiState = homeViewModel.homeUiState,
                musicPlaybackUiState = musicPlaybackUiState,
                onNavigateToMusicPlayer = {
                    navController.navigate(Screen.MusicPlayer.route)
                }
            )
        }

        composable(Screen.MusicPlayer.route) {
            MusicPlayerScreen(musicPlaybackUiState)
        }
    }
}