package com.ajailani.musicplayer.data.mapper

import androidx.media3.common.MediaItem
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

fun MediaItem.toMusic() =
    Music(
        id = mediaId,
        title = mediaMetadata.title.toString(),
        artist = mediaMetadata.artist.toString(),
        source = mediaId,
        image = mediaMetadata.artworkUri.toString()
    )