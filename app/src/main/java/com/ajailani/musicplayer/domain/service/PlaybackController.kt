package com.ajailani.musicplayer.domain.service

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.util.PlayerState

interface PlaybackController {
    var mediaControllerCallback: (playerState: PlayerState) -> Unit

    fun addMediaItems(musics: List<Music>)
    fun play(mediaItemIndex: Int)
    fun resume()
    fun pause()
}