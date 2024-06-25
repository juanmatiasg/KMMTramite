package com.example.kmmtramites.data.model

import com.example.kmmtramites.domain.model.Tramite
import kotlinx.serialization.Serializable

@Serializable
data class TramiteResponse(
    val data:List<TramiteData>,
    val isSuccess:Boolean,
    val message:String
)

