package com.ajailani.musicplayer.ui.shared_component

import androidx.media3.common.MediaItem
import com.ajailani.musicplayer.util.PlayerState

data class MusicPlaybackUiState(
    val playerState: PlayerState? = null,
    val currentMediaItem: MediaItem? = null
)
