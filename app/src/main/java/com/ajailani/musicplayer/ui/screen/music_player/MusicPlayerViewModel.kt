package com.ajailani.musicplayer.ui.screen.music_player

import androidx.lifecycle.ViewModel
import com.ajailani.musicplayer.domain.use_case.PauseMusicUseCase
import com.ajailani.musicplayer.domain.use_case.PlayMusicUseCase
import com.ajailani.musicplayer.domain.use_case.ResumeMusicUseCase
import com.ajailani.musicplayer.domain.use_case.SeekMusicPositionUseCase
import com.ajailani.musicplayer.ui.screen.home.HomeEvent

class MusicPlayerViewModel(
    private val resumeMusicUseCase: ResumeMusicUseCase,
    private val pauseMusicUseCase: PauseMusicUseCase,
    private val seekMusicPositionUseCase: SeekMusicPositionUseCase
) : ViewModel() {
    fun onEvent(event: MusicPlayerEvent) {
        when (event) {
            MusicPlayerEvent.ResumeMusic -> resume()

            MusicPlayerEvent.PauseMusic -> pause()

            is MusicPlayerEvent.SeekMusicPosition -> seekTo(event.musicPosition)
        }
    }

    private fun resume() {
        resumeMusicUseCase()
    }

    private fun pause() {
        pauseMusicUseCase()
    }

    private fun seekTo(position: Long) {
        seekMusicPositionUseCase(position)
    }
}