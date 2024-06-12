package com.example.kmmtramites.domain.repository

import com.example.kmmtramites.domain.model.Photo

interface PhotosRepository{
    suspend fun getPhotos(): List<Photo>
}