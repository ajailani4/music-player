package com.ajailani.musicplayer.di

import com.ajailani.musicplayer.data.remote.api_service.MusicService
import com.ajailani.musicplayer.data.remote.data_source.MusicRemoteDataSource
import com.ajailani.musicplayer.data.repository.MusicRepositoryImpl
import com.ajailani.musicplayer.data.service.MusicPlaybackController
import com.ajailani.musicplayer.domain.repository.MusicRepository
import com.ajailani.musicplayer.domain.service.PlaybackController
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { MusicService(get()) }
    single { MusicRemoteDataSource(get()) }
    single<MusicRepository> { MusicRepositoryImpl(get()) }
    single<PlaybackController> { MusicPlaybackController(androidContext()) }
}