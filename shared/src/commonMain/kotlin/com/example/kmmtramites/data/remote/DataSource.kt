package com.example.kmmtramites.data.remote

 class DataSource(private val apiService: TramiteService) {
    suspend fun getListTramite(correlativo:String) = apiService.getAllTramite(correlativo)
}