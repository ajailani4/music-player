package com.ajailani.musicplayer.ui.screen.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ajailani.musicplayer.domain.model.Music
import com.ajailani.musicplayer.util.PlayerState

@Composable
fun MusicItem(
    music: Music,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
            AsyncImage(
                modifier = Modifier
                    .size(45.dp)
                    .shadow(
                        elevation = 1.dp,
                        shape = MaterialTheme.shapes.small
                    )
                    .clip(MaterialTheme.shapes.small),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(music.image)
                    .build(),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Music cover"
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = music.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = music.artist,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}