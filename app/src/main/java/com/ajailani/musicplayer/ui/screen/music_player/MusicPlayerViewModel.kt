package com.ajailani.musicplayer.ui.screen.music_player

import androidx.lifecycle.ViewModel
import com.ajailani.musicplayer.domain.use_case.PauseMusicUseCase
import com.ajailani.musicplayer.domain.use_case.ResumeMusicUseCase
import com.ajailani.musicplayer.domain.use_case.SeekMusicPositionUseCase
import com.ajailani.musicplayer.domain.use_case.SkipNextMusicUseCase
import com.ajailani.musicplayer.domain.use_case.SkipPreviousMusicUseCase

class MusicPlayerViewModel(
    private val resumeMusicUseCase: ResumeMusicUseCase,
    private val pauseMusicUseCase: PauseMusicUseCase,
    private val seekMusicPositionUseCase: SeekMusicPositionUseCase,
    private val skipNextMusicUseCase: SkipNextMusicUseCase,
    private val skipPreviousMusicUseCase: SkipPreviousMusicUseCase
) : ViewModel() {
    fun onEvent(event: MusicPlayerEvent) {
        when (event) {
            MusicPlayerEvent.ResumeMusic -> resumeMusic()

            MusicPlayerEvent.PauseMusic -> pauseMusic()

            MusicPlayerEvent.SkipNextMusic -> skipNextMusic()

            MusicPlayerEvent.SkipPreviousMusic -> skipPreviousMusic()

            is MusicPlayerEvent.SeekMusicPosition -> seekToMusicPosition(event.musicPosition)
        }
    }

    private fun resumeMusic() {
        resumeMusicUseCase()
    }

    private fun pauseMusic() {
        pauseMusicUseCase()
    }

    private fun seekToMusicPosition(position: Long) {
        seekMusicPositionUseCase(position)
    }

    private fun skipNextMusic() {
        skipNextMusicUseCase()
    }

    private fun skipPreviousMusic() {
        skipPreviousMusicUseCase()
    }
}