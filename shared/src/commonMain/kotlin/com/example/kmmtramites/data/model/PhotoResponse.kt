package com.example.kmmtramites.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PhotoResponse(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)