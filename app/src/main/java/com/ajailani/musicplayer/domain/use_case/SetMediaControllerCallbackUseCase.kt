package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.domain.service.PlaybackController
import com.ajailani.musicplayer.util.PlayerState

class SetMediaControllerCallbackUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke(
        callback: (
            playerState: PlayerState,
            currentMusic: Music?,
            currentPosition: Long,
            totalDuration: Long,
            isShuffleEnabled: Boolean,
            isRepeatOneEnabled: Boolean
        ) -> Unit
    ) {
        playbackController.mediaControllerCallback = callback
    }
}