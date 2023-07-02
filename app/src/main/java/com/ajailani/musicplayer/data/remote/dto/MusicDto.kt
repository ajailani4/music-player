package com.ajailani.musicplayer.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MusicDto(
    val id: String,
    val title: String,
    val artist: String,
    val source: String,
    val image: String
)
