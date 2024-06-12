package com.example.kmmtramites.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Photo (
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)