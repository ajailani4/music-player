package com.ajailani.musicplayer.ui.screen.home

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.util.PlayerState

sealed class HomeEvent {
    object PlayMusic : HomeEvent()
    object ResumeMusic : HomeEvent()
    object PauseMusic : HomeEvent()
    data class OnMusicSelected(val selectedMusic: Music) : HomeEvent()
}
