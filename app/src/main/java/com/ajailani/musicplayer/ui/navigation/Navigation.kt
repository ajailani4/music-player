package com.ajailani.musicplayer.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ajailani.musicplayer.ui.screen.home.HomeScreen
import com.ajailani.musicplayer.ui.screen.home.HomeViewModel
import com.ajailani.musicplayer.ui.screen.music_player.MusicPlayerScreen
import com.ajailani.musicplayer.ui.screen.music_player.MusicPlayerViewModel
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

        composable(
            route = Screen.MusicPlayer.route,
            enterTransition = {
                expandVertically(
                    animationSpec = tween(300),
                    expandFrom = Alignment.Top
                )
            },
            exitTransition = {
                shrinkVertically(
                    animationSpec = tween(300),
                    shrinkTowards = Alignment.Top
                )
            }
        ) {
            val musicPlayerViewModel: MusicPlayerViewModel = koinViewModel()

            MusicPlayerScreen(
                onEvent = musicPlayerViewModel::onEvent,
                musicPlaybackUiState = musicPlaybackUiState,
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}