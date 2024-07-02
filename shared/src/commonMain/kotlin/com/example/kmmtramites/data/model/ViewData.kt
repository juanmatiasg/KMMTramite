package com.example.kmmtramites.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ViewData (
    var inicioTramite:String,
    var inicioVista:String,
    var inspector:String,
    var detalle:String
)