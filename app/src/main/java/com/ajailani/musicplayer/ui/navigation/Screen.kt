package com.ajailani.musicplayer.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
}
