package com.example.kmmtramites.data.repository

import com.example.kmmtramites.data.remote.DataSource
import com.example.kmmtramites.domain.model.Entidad
import com.example.kmmtramites.domain.repository.EntidadRepository

class EntidadRepositoryImpl(private val dataSource: DataSource) :EntidadRepository {
    override suspend fun getEntidadForCorrelativo(correlativo: String): Entidad {
        return dataSource.getEntidadForCorrelativo(correlativo)
    }

    override suspend fun getEntidadForTramite(tramite: String): Entidad {
        return dataSource.getEntidadForTramite(tramite)
    }
}