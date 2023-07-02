package com.ajailani.musicplayer.domain.use_case

import com.ajailani.musicplayer.domain.repository.MusicRepository

class GetMusicsUseCase(private val musicRepository: MusicRepository) {
    operator fun invoke() = musicRepository.getMusics()
}