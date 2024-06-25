package com.example.kmmtramites.domain.repository

import com.example.kmmtramites.domain.model.Tramite

interface TramiteRepository{
    suspend fun getListTramite(correlativo:String): List<Tramite>
}