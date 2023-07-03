package com.ajailani.musicplayer.ui.screen.music_player

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ajailani.musicplayer.ui.shared_component.MusicPlaybackUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicPlayerScreen(
    //musicPlaybackUiState: MusicPlaybackUiState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Minimize music player"
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /*musicPlaybackUiState.currentMediaItem?.mediaMetadata?.let {

                }*/
                AsyncImage(
                    modifier = Modifier
                        .size(280.dp)
                        .clip(MaterialTheme.shapes.large),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(/*it.artworkUri*/"https://storage.googleapis.com/automotive-media/album_art.jpg")
                        .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Music cover"
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = /*it.title.toString()*/"Test",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = /*it.artist.toString()*/"Someone",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(30.dp))
                CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                    Slider(
                        value = 0.5f,
                        onValueChange = {}
                    )
                }
                Spacer(modifier = Modifier.height(3.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "2:30",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "5:00",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .clickable {},
                        imageVector = Icons.Default.Shuffle,
                        contentDescription = "Shuffle button"
                    )
                    Icon(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .clickable {},
                        imageVector = Icons.Default.SkipPrevious,
                        contentDescription = "Skip previous button"
                    )
                    Icon(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .clickable {},
                        imageVector = Icons.Default.PlayCircle,
                        contentDescription = "Play button"
                    )
                    Icon(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .clickable {},
                        imageVector = Icons.Default.SkipNext,
                        contentDescription = "Skip next button"
                    )
                    Icon(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .clickable {},
                        imageVector = Icons.Default.Repeat,
                        contentDescription = "Repeat button"
                    )
                }
            }
        }
    }
}