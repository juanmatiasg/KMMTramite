package com.example.kmmtramites.data.remote

 class DataSource(private val apiService: PhotosService) {
    suspend fun getListPhoto() = apiService.getAllPhotos()
}