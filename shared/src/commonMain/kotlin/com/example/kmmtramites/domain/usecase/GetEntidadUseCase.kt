package com.example.kmmtramites.domain.usecase

import com.example.kmmtramites.domain.model.Entidad
import com.example.kmmtramites.domain.model.Tramite
import com.example.kmmtramites.domain.repository.EntidadRepository
import com.example.kmmtramites.domain.repository.TramiteRepository

class GetEntidadUseCase(private val tramiteRepository: EntidadRepository) {

    suspend fun getEntidadForCorrelativo(correlativo:String): Entidad {
        return tramiteRepository.getEntidadForCorrelativo(correlativo)
    }

    suspend  fun getEntidadForTramite(tramite:String): Entidad {
        return tramiteRepository.getEntidadForTramite(tramite)
    }
}