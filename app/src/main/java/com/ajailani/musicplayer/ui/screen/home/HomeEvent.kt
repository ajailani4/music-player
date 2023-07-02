package com.ajailani.musicplayer.ui.screen.home

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.util.PlayerState

sealed class HomeEvent {
    object PlayMusic : HomeEvent()
    object PauseMusic : HomeEvent()
    data class OnMusicSelected(val selectedMusic: Music) : HomeEvent()
    data class OnPlayerStateChanged(val playerState: PlayerState) : HomeEvent()
}
