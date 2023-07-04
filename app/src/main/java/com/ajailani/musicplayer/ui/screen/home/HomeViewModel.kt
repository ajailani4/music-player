package com.ajailani.musicplayer.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajailani.musicplayer.domain.use_case.AddMediaItemsUseCase
import com.ajailani.musicplayer.domain.use_case.GetMusicsUseCase
import com.ajailani.musicplayer.domain.use_case.PauseMusicUseCase
import com.ajailani.musicplayer.domain.use_case.PlayMusicUseCase
import com.ajailani.musicplayer.domain.use_case.ResumeMusicUseCase
import com.ajailani.musicplayer.util.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMusicsUseCase: GetMusicsUseCase,
    private val addMediaItemsUseCase: AddMediaItemsUseCase,
    private val playMusicUseCase: PlayMusicUseCase,
    private val resumeMusicUseCase: ResumeMusicUseCase,
    private val pauseMusicUseCase: PauseMusicUseCase
) : ViewModel() {
    var homeUiState by mutableStateOf(HomeUiState())
        private set

    init {
        getMusics()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.PlayMusic -> play()

            HomeEvent.ResumeMusic -> resume()

            HomeEvent.PauseMusic -> pause()

            is HomeEvent.OnMusicSelected -> {
                homeUiState = homeUiState.copy(selectedMusic = event.selectedMusic)
            }
        }
    }

    private fun getMusics() {
        homeUiState = homeUiState.copy(loading = true)

        viewModelScope.launch {
            getMusicsUseCase().catch {
                homeUiState = homeUiState.copy(
                    loading = false,
                    errorMessage = it.message
                )
            }.collect {
                homeUiState = when (it) {
                    is Resource.Success -> {
                        it.data?.let { musics ->
                            addMediaItemsUseCase(musics)
                        }

                        homeUiState.copy(
                            loading = false,
                            musics = it.data
                        )
                    }

                    is Resource.Error -> {
                        homeUiState.copy(
                            loading = false,
                            errorMessage = it.message
                        )
                    }
                }
            }
        }
    }

    private fun play() {
        homeUiState.apply {
            musics?.indexOf(selectedMusic)?.let {
                playMusicUseCase(it)
            }
        }
    }

    private fun resume() {
        resumeMusicUseCase()
    }

    private fun pause() {
        pauseMusicUseCase()
    }
}