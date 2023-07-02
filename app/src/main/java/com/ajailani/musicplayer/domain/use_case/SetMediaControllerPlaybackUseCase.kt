package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.data.service.MusicPlaybackController
import com.ajailani.musicplayer.domain.service.PlaybackController
import com.ajailani.musicplayer.util.PlayerState

class SetMediaControllerPlaybackUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke(callback: (playerState: PlayerState) -> Unit) {
        playbackController.mediaControllerCallback = callback
    }
}