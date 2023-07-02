package com.ajailani.musicplayer.data.mapper

import com.ajailani.musicplayer.data.remote.dto.MusicDto
import com.ajailani.musicplayer.domain.model.Music

fun MusicDto.toMusic() =
    Music(
        id = id,
        title = title,
        artist = artist,
        source = source,
        image = image
    )