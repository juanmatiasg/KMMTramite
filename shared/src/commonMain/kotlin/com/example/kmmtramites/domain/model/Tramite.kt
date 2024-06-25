package com.example.kmmtramites.domain.model


data class Tramite (
    var numero: String,
    var descripcion: String,
    var destinoActual: String,
    var fechaInicioTramite: String,
    var fechaDestinoActual: String,
    var tieneVista:Boolean
)

