package com.ajailani.musicplayer.di

import com.ajailani.musicplayer.domain.use_case.GetMusicsUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetMusicsUseCase(get()) }
}