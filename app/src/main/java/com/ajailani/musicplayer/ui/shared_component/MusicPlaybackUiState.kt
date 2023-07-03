package com.ajailani.musicplayer.ui.shared_component

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.util.PlayerState

data class MusicPlaybackUiState(
    val playerState: PlayerState? = null,
    val currentMusic: Music? = null,
    val currentPosition: Long = 0L,
    val totalDuration: Long = 0L
)
