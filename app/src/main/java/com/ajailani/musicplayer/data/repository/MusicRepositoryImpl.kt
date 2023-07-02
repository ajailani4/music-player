package com.ajailani.musicplayer.data.repository

import com.ajailani.musicplayer.data.remote.data_source.MusicDataSource
import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.domain.repository.MusicRepository
import com.ajailani.musicplayer.util.Resource
import kotlinx.coroutines.flow.Flow

class MusicRepositoryImpl(
    private val musicDataSource: MusicDataSource
) : MusicRepository {
    override fun getMusics(): Flow<Resource<List<Music>>> {
        TODO("Not yet implemented")
    }
}