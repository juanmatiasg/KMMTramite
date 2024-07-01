package com.example.kmmtramites.data.remote

 class DataSource(private val apiService: TramiteService,
                  private val entidadService: EntidadService) {
    suspend fun getListTramite(correlativo:String) = apiService.getAllTramite(correlativo)

     suspend fun getEntidadForCorrelativo(correlativo: String) = entidadService.findForCorrelativo(correlativo)

     suspend fun getEntidadForTramite(tramite: String) = entidadService.findForTramite(tramite)

 }