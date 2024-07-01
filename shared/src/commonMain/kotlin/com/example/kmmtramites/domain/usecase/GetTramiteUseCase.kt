package com.example.kmmtramites.domain.usecase

import com.example.kmmtramites.domain.model.Tramite
import com.example.kmmtramites.domain.repository.TramiteRepository

class GetTramiteUseCase(private val tramiteRepository: TramiteRepository) {

    suspend operator fun invoke(correlativo:String): List<Tramite> {
        return tramiteRepository.getListTramite(correlativo)
    }
}