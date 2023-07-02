package com.ajailani.musicplayer.domain.repository

import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.util.Resource
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun getMusics(): Flow<Resource<List<Music>>>
}