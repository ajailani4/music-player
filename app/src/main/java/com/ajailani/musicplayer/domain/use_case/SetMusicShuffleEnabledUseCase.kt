package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.domain.service.PlaybackController

class SetMusicShuffleEnabledUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke(isEnabled: Boolean) {
        playbackController.setShuffleModeEnabled(isEnabled)
    }
}