package com.example.kmmtramites.data.remote

import com.example.kmmtramites.data.model.PhotosListResponse
import com.example.kmmtramites.domain.model.Photo
import io.ktor.client.call.body
import io.ktor.client.request.get

 class PhotosService: KtorApi() {
    suspend fun getAllPhotos(): List<Photo> {
       return client.get { pathUrl("photos") }.body<PhotosListResponse>().toDomain()
    }


    fun PhotosListResponse.toDomain(): List<Photo> {
        return this.photos.map{
            Photo(
                albumId = it.albumId,
                id = it.id,
                thumbnailUrl = it.thumbnailUrl,
                title = it.title,
                url = it.url
            )
        }
    }
}