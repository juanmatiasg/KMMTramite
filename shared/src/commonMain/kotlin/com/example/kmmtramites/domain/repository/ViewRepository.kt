package com.example.kmmtramites.domain.repository

import com.example.kmmtramites.domain.model.View

interface ViewRepository {
    suspend fun getListView(correlativo:String,tramite:String):List<View>
}