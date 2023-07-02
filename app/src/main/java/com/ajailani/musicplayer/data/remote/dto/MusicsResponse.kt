package com.ajailani.musicplayer.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MusicsResponse(
    @SerialName("music")
    val musics: List<MusicDto>
)
