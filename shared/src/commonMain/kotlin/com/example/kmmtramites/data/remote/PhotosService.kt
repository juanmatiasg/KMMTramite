package com.example.kmmtramites.data.remote

import com.example.kmmtramites.data.model.PhotoResponse
import com.example.kmmtramites.data.model.PhotosListResponse
import com.example.kmmtramites.domain.model.Photo
import io.ktor.client.call.body
import io.ktor.client.request.get

 class PhotosService: KtorApi() {
     suspend fun getAllPhotos(): List<Photo> {
         return client.get { pathUrl("photos") }.body<List<PhotoResponse>>().map { it.toDomain() }
     }


     private fun PhotoResponse.toDomain(): Photo {
         return Photo(
             albumId = albumId,
             id = id,
             title = title,
             url = url,
             thumbnailUrl = thumbnailUrl
         )
     }
 }