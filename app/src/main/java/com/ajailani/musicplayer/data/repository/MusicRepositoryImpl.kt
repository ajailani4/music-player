package com.ajailani.musicplayer.data.repository

import com.ajailani.musicplayer.data.mapper.toMusic
import com.ajailani.musicplayer.data.remote.data_source.MusicRemoteDataSource
import com.ajailani.musicplayer.data.remote.dto.MusicsResponse
import com.ajailani.musicplayer.domain.repository.MusicRepository
import com.ajailani.musicplayer.util.Resource
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.flow

class MusicRepositoryImpl(
    private val musicRemoteDataSource: MusicRemoteDataSource
) : MusicRepository {
    override fun getMusics() =
        flow {
            val response = musicRemoteDataSource.getMusics()

            when (response.status) {
                HttpStatusCode.OK -> {
                    val musicsResponse = response.body<MusicsResponse>()
                    val musics = musicsResponse.musics

                    emit(Resource.Success(musics.map { it.toMusic() }))
                }
            }
        }
}