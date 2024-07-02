package com.example.kmmtramites.data.repository

import com.example.kmmtramites.data.remote.DataSource
import com.example.kmmtramites.domain.model.View
import com.example.kmmtramites.domain.repository.ViewRepository

class ViewRepositoryImpl(private val dataSource: DataSource):ViewRepository {
    override suspend fun getListView(correlativo: String, tramite: String): List<View> {
        return dataSource.getListView(correlativo, tramite)
    }
}