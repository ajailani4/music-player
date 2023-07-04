package com.ajailani.musicplayer.ui.screen.music_player

import androidx.lifecycle.ViewModel
import com.ajailani.musicplayer.domain.use_case.SetMusicShuffleEnabledUseCase
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
    private val skipPreviousMusicUseCase: SkipPreviousMusicUseCase,
    private val setMusicShuffleEnabledUseCase: SetMusicShuffleEnabledUseCase
) : ViewModel() {
    fun onEvent(event: MusicPlayerEvent) {
        when (event) {
            MusicPlayerEvent.ResumeMusic -> resumeMusic()

            MusicPlayerEvent.PauseMusic -> pauseMusic()

            MusicPlayerEvent.SkipNextMusic -> skipNextMusic()

            MusicPlayerEvent.SkipPreviousMusic -> skipPreviousMusic()

            is MusicPlayerEvent.SeekMusicPosition -> seekToMusicPosition(event.musicPosition)

            is MusicPlayerEvent.SetMusicShuffleEnabled -> setMusicShuffleEnabled(event.isShuffleEnabled)
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

    private fun setMusicShuffleEnabled(isEnabled: Boolean) {
        setMusicShuffleEnabledUseCase(isEnabled)
    }
}