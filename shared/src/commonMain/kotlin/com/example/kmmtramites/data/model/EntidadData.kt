package com.example.kmmtramites.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    var razonSocial:String,
    var tipoSocietario:String,
    var correlativo:String
)