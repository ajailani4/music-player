package com.ajailani.musicplayer.di

import com.ajailani.musicplayer.domain.use_case.AddMediaItemsUseCase
import com.ajailani.musicplayer.domain.use_case.DestroyMediaControllerUseCase
import com.ajailani.musicplayer.domain.use_case.GetCurrentMusicPositionUseCase
import com.ajailani.musicplayer.domain.use_case.GetMusicsUseCase
import com.ajailani.musicplayer.domain.use_case.PauseMusicUseCase
import com.ajailani.musicplayer.domain.use_case.PlayMusicUseCase
import com.ajailani.musicplayer.domain.use_case.ResumeMusicUseCase
import com.ajailani.musicplayer.domain.use_case.SeekMusicPositionUseCase
import com.ajailani.musicplayer.domain.use_case.SetMediaControllerCallbackUseCase
import com.ajailani.musicplayer.domain.use_case.SkipNextMusicUseCase
import com.ajailani.musicplayer.domain.use_case.SkipPreviousMusicUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetMusicsUseCase(get()) }
    single { AddMediaItemsUseCase(get()) }
    single { SetMediaControllerCallbackUseCase(get()) }
    single { PlayMusicUseCase(get()) }
    single { ResumeMusicUseCase(get()) }
    single { PauseMusicUseCase(get()) }
    single { SeekMusicPositionUseCase(get()) }
    single { SkipNextMusicUseCase(get()) }
    single { SkipPreviousMusicUseCase(get()) }
    single { GetCurrentMusicPositionUseCase(get()) }
    single { DestroyMediaControllerUseCase(get()) }
}