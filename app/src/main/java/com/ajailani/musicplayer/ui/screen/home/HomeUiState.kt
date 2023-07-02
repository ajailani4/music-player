package com.ajailani.musicplayer.ui.screen.home

import com.ajailani.musicplayer.domain.model.Music

data class HomeUiState(
    val loading: Boolean? = false,
    val musics: List<Music>? = emptyList(),
    val errorMessage: String? = null
)
