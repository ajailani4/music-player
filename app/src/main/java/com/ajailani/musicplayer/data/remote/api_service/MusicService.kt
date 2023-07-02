package com.ajailani.musicplayer.data.remote.api_service

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MusicService(private val httpClient: HttpClient) {
    suspend fun getMusics() =
        httpClient.get("https://storage.googleapis.com/uamp/catalog.json")
}