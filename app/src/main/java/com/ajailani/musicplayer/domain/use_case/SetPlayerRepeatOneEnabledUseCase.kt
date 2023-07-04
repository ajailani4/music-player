package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.domain.service.PlaybackController

class SetPlayerRepeatOneEnabledUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke(isEnabled: Boolean) {
        playbackController.setRepeatOneEnabled(isEnabled)
    }
}