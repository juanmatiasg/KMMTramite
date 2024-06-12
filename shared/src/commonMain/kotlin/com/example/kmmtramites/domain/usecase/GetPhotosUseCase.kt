package com.example.kmmtramites.domain.usecase

import com.example.kmmtramites.domain.model.Photo
import com.example.kmmtramites.domain.repository.PhotosRepository

class GetPhotosUseCase(private val photosRepository: PhotosRepository) {
    suspend operator fun invoke(): List<Photo> {
        return photosRepository.getPhotos()
    }
}