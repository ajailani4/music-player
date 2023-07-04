package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.domain.service.PlaybackController

class SeekMusicPositionUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke(position: Long) {
        playbackController.seekTo(position)
    }
}