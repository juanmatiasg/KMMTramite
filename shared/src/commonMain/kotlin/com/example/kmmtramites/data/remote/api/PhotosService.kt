package com.example.kmmtramites.data.remote.api

import com.example.kmmtramites.domain.model.Photo
import io.ktor.client.request.get


class PhotosService(private val httpClient:KtorClient) {
    suspend fun fetchListPhotos():List<Photo> {
       return emptyList()

    }
}