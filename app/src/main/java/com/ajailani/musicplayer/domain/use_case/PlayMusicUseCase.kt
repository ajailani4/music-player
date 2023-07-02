package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.domain.service.PlaybackController

class PlayMusicUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke(mediaItemsIndex: Int) {
        playbackController.play(mediaItemsIndex)
    }
}