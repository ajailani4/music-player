package com.ajailani.musicplayer.domain.service

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.util.PlayerState

interface PlaybackController {
    var mediaControllerCallback: (
        (playerState: PlayerState,
         currentMusic: Music?,
         currentPosition: Long,
         totalDuration: Long,
         isShuffleEnabled: Boolean) -> Unit
    )?

    fun addMediaItems(musics: List<Music>)

    fun play(mediaItemIndex: Int)

    fun resume()

    fun pause()

    fun seekTo(position: Long)

    fun skipNext()

    fun skipPrevious()

    fun setShuffleModeEnabled(isEnabled: Boolean)

    fun getCurrentPosition(): Long

    fun destroy()
}