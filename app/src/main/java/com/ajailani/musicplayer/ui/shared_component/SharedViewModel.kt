package com.ajailani.musicplayer.ui.shared_component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ajailani.musicplayer.domain.use_case.SetMediaControllerPlaybackUseCase

class SharedViewModel(
    private val setMediaControllerPlaybackUseCase: SetMediaControllerPlaybackUseCase,
) : ViewModel() {
    var musicPlaybackUiState by mutableStateOf(MusicPlaybackUiState())
        private set

    init {
        setMediaControllerPlayback()
    }

    private fun setMediaControllerPlayback() {
        setMediaControllerPlaybackUseCase {
            musicPlaybackUiState = musicPlaybackUiState.copy(
                playerState = it
            )
        }
    }
}