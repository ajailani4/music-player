package com.ajailani.musicplayer.ui.shared_component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajailani.musicplayer.domain.use_case.DestroyMediaControllerUseCase
import com.ajailani.musicplayer.domain.use_case.GetCurrentMusicPositionUseCase
import com.ajailani.musicplayer.domain.use_case.SetMediaControllerCallbackUseCase
import com.ajailani.musicplayer.util.PlayerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class SharedViewModel(
    private val setMediaControllerCallbackUseCase: SetMediaControllerCallbackUseCase,
    private val getCurrentMusicPositionUseCase: GetCurrentMusicPositionUseCase,
    private val destroyMediaControllerUseCase: DestroyMediaControllerUseCase
) : ViewModel() {
    var musicPlaybackUiState by mutableStateOf(MusicPlaybackUiState())
        private set

    init {
        setMediaControllerCallback()
    }

    private fun setMediaControllerCallback() {
        setMediaControllerCallbackUseCase { playerState, currentMusic, currentPosition, totalDuration,
                                            isShuffleEnabled, isRepeatOneEnabled ->
            musicPlaybackUiState = musicPlaybackUiState.copy(
                playerState = playerState,
                currentMusic = currentMusic,
                currentPosition = currentPosition,
                totalDuration = totalDuration,
                isShuffleEnabled = isShuffleEnabled,
                isRepeatOneEnabled = isRepeatOneEnabled
            )

            if (playerState == PlayerState.PLAYING) {
                viewModelScope.launch {
                    while (true) {
                        delay(1.seconds)
                        musicPlaybackUiState = musicPlaybackUiState.copy(
                            currentPosition = getCurrentMusicPositionUseCase()
                        )
                    }
                }
            }
        }
    }

    fun destroyMediaController() {
        destroyMediaControllerUseCase()
    }
}