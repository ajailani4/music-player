package com.ajailani.musicplayer.ui.screen.music_player

sealed class MusicPlayerEvent {
    object ResumeMusic : MusicPlayerEvent()
    object PauseMusic : MusicPlayerEvent()
    object SkipNextMusic : MusicPlayerEvent()
    object SkipPreviousMusic : MusicPlayerEvent()
    data class SeekMusicPosition(val musicPosition: Long) : MusicPlayerEvent()
    data class SetMusicShuffleEnabled(val isShuffleEnabled: Boolean) : MusicPlayerEvent()
    data class SetPlayerRepeatOneEnabled(val isRepeatOneEnabled: Boolean) : MusicPlayerEvent()
}
