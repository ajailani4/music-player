package com.ajailani.musicplayer.ui.screen.home

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.util.PlayerState

data class HomeUiState(
    val loading: Boolean? = false,
    val musics: List<Music>? = emptyList(),
    val selectedMusic: Music? = null,
    val errorMessage: String? = null
)
