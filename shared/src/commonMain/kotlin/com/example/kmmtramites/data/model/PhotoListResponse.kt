package com.example.kmmtramites.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PhotosListResponse(
    val photos: List<PhotoResponse>
)