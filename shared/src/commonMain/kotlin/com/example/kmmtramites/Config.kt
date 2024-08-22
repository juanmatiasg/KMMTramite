package com.example.kmmtramites

object Config {

    //Base URL
    const val BASE_URL = "http://10.2.27.112:8001" //Emulator
    //const val BASE_URL = "http://appsdesa" //Remote IP


    //Endpoints Entidad
    const val ENDPOINT_ENTIDAD_TRAMITE = "/api/Entidad/BusquedaporTramite"
    const val ENDPOINT_ENTIDAD_CORRELATIVO = "/api/Entidad/BusquedaPorCorrelativo"

    //Endpoints Tramite
    const val ENDPOINT_TRAMITE = "/api/Tramite/TramitesPorCorrelativo"

    //Endpoints Vista
    const val ENDPOINT_VIEW ="/api/Vista/VistasPorCorrelativoYNroTramite"

}