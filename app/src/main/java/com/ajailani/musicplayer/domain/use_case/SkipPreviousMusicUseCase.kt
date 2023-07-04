package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.domain.service.PlaybackController

class SkipPreviousMusicUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke() {
        playbackController.skipPrevious()
    }
}