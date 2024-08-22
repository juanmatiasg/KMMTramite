package com.example.kmmtramites.data.model

import com.example.kmmtramites.domain.model.Entidad
import kotlinx.serialization.Serializable

@Serializable
data class EntidadResponse(
    val data: Data,
    val isSuccess:Boolean,
    val message:String
)