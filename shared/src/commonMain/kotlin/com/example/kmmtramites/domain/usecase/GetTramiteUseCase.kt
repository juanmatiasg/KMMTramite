package com.example.kmmtramites.domain.usecase

import com.example.kmmtramites.domain.model.Tramite
import com.example.kmmtramites.domain.repository.TramiteRepository

class GetTramiteUseCase(private val photosRepository: TramiteRepository) {

    suspend operator fun invoke(correlativo:String): List<Tramite> {
        return photosRepository.getListTramite(correlativo)
    }
}