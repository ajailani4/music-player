package com.ajailani.musicplayer.data.service

import android.content.ComponentName
import android.content.Context
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.domain.service.PlaybackController
import com.ajailani.musicplayer.util.PlayerState
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.MoreExecutors

class MusicPlaybackController(context: Context) : PlaybackController {

    private var mediaControllerFuture: ListenableFuture<MediaController>
    private val mediaController: MediaController?
        get() = if (mediaControllerFuture.isDone) mediaControllerFuture.get() else null

    override lateinit var mediaControllerCallback: (playerState: PlayerState) -> Unit

    init {
        val sessionToken = SessionToken(context, ComponentName(context, MusicPlaybackService::class.java))
        mediaControllerFuture = MediaController.Builder(context, sessionToken).buildAsync()
        mediaControllerFuture.addListener({ controllerListener() }, MoreExecutors.directExecutor())
    }

    private fun controllerListener() {
        mediaController?.addListener(object : Player.Listener {
            override fun onEvents(player: Player, events: Player.Events) {
                super.onEvents(player, events)

                val playerState = mapPlaybackStateToPlayerState(
                    playbackState = player.playbackState,
                    isPlaying = player.isPlaying
                )

                mediaControllerCallback(playerState)
            }
        })
    }

    private fun mapPlaybackStateToPlayerState(playbackState: Int, isPlaying: Boolean): PlayerState {
        return when (playbackState) {
            Player.STATE_IDLE -> PlayerState.STOPPED
            Player.STATE_ENDED -> PlayerState.STOPPED
            else -> if (isPlaying) PlayerState.PLAYING else PlayerState.PAUSED
        }
    }

    override fun addMediaItems(musics: List<Music>) {
        val mediaItems = musics.map {
            MediaItem.Builder()
                .setMediaId(it.source)
                .setUri(it.source)
                .setMediaMetadata(
                    MediaMetadata.Builder()
                        .setTitle(it.title)
                        .setArtist(it.artist)
                        .setArtworkUri(Uri.parse(it.image))
                        .build()
                )
                .build()
        }

        mediaController?.setMediaItems(mediaItems)
    }

    override fun play(mediaItemIndex: Int) {
        mediaController?.apply {
            seekToDefaultPosition(mediaItemIndex)
            playWhenReady = true
            prepare()
        }
    }

    override fun resume() {
        mediaController?.play()
    }

    override fun pause() {
        mediaController?.pause()
    }
}