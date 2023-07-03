package com.ajailani.musicplayer.ui.shared_component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ajailani.musicplayer.domain.use_case.DestroyMediaControllerUseCase
import com.ajailani.musicplayer.domain.use_case.SetMediaControllerCallbackUseCase

class SharedViewModel(
    private val setMediaControllerCallbackUseCase: SetMediaControllerCallbackUseCase,
    private val destroyPlaybackCallbackUseCase: DestroyMediaControllerUseCase
) : ViewModel() {
    var musicPlaybackUiState by mutableStateOf(MusicPlaybackUiState())
        private set

    init {
        setMediaControllerCallback()
    }

    private fun setMediaControllerCallback() {
        setMediaControllerCallbackUseCase { playerState, currentMusic ->
            musicPlaybackUiState = musicPlaybackUiState.copy(
                playerState = playerState,
                currentMusic = currentMusic
            )
        }
    }

    fun destroyMediaController() {
        destroyPlaybackCallbackUseCase()
    }
}