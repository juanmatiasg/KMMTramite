package com.example.kmmtramites.domain.repository

import com.example.kmmtramites.domain.model.Entidad
import com.example.kmmtramites.domain.model.Tramite

interface EntidadRepository {
    suspend fun getEntidadForCorrelativo(correlativo:String): Entidad
    suspend fun getEntidadForTramite(tramite:String): Entidad


}