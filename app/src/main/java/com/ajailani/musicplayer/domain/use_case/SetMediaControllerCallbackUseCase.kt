package com.ajailani.musicplayer.domain.use_case

import androidx.media3.common.MediaItem
import com.ajailani.musicplayer.domain.service.PlaybackController
import com.ajailani.musicplayer.util.PlayerState

class SetMediaControllerCallbackUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke(callback: (playerState: PlayerState, currentMediaItem: MediaItem?) -> Unit) {
        playbackController.mediaControllerCallback = callback
    }
}