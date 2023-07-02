package com.ajailani.musicplayer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ajailani.musicplayer.ui.screen.home.HomeScreen
import com.ajailani.musicplayer.ui.screen.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            val homeViewModel = koinViewModel<HomeViewModel>()

            HomeScreen(homeViewModel.homeUiState)
        }
    }
}