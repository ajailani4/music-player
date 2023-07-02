package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.domain.service.PlaybackController

class AddMediaItemsUseCase(
    private val playbackController: PlaybackController
) {
    operator fun invoke(musics: List<Music>) {
        playbackController.addMediaItems(musics)
    }
}