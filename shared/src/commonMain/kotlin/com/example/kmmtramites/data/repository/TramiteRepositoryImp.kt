package com.example.kmmtramites.data.repository

import com.example.kmmtramites.data.remote.DataSource
import com.example.kmmtramites.domain.model.Tramite
import com.example.kmmtramites.domain.repository.TramiteRepository

internal class TramiteRepositoryImp(private val dataSource: DataSource): TramiteRepository {
    override suspend fun getListTramite(correlativo:String): List<Tramite> {
        return dataSource.getListTramite(correlativo)
    }
}