package com.example.kmmtramites

object Config {

    //Base URL
    const val BASE_URL = "https://10.0.2.2:7044"

    //Endpoints Entidad
    const val ENDPOINT_ENTIDAD_TRAMITE = "/api/Entidad/BusquedaporTramite"
    const val ENDPOINT_ENTIDAD_CORRELATIVO = "/api/Entidad/BusquedaPorCorrelativo"

    //Endpoints Tramite
    const val ENDPOINT_TRAMITE = "/api/Tramite/TramitesPorCorrelativo"

    //Endpoints Vista
    const val ENDPOINT_VIEW ="/api/Vista/VistasPorCorrelativoYNroTramite"

}