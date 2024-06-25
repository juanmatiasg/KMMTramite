package com.example.kmmtramites.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TramiteData (
    var numero: String,
    var descripcion: String,
    var destinoActual: String,
    var fechaInicioTramite: String,
    var fechaDestinoActual: String,
    var tieneVista:Boolean
)