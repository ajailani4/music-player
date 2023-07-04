package com.ajailani.musicplayer.di

import com.ajailani.musicplayer.ui.shared_component.SharedViewModel
import com.ajailani.musicplayer.ui.screen.home.HomeViewModel
import com.ajailani.musicplayer.ui.screen.music_player.MusicPlayerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SharedViewModel(get(), get(), get()) }
    viewModel { HomeViewModel(get(), get(), get(), get(), get()) }
    viewModel { MusicPlayerViewModel(get(), get(), get()) }
}