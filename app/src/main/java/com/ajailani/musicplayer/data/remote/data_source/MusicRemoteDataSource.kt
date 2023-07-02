package com.ajailani.musicplayer.data.remote.data_source

import com.ajailani.musicplayer.data.remote.api_service.MusicService

class MusicRemoteDataSource(private val musicService: MusicService) {
    suspend fun getMusics() = musicService.getMusics()
}