package com.example.kmmtramites.data.repository

import com.example.kmmtramites.data.remote.DataSource
import com.example.kmmtramites.data.remote.PhotosService
import com.example.kmmtramites.domain.model.Photo
import com.example.kmmtramites.domain.repository.PhotosRepository

internal class PhotosRepositoryImp(private val dataSource: DataSource): PhotosRepository {
    override suspend fun getPhotos(): List<Photo> {
        return dataSource.getListPhoto()
    }
}