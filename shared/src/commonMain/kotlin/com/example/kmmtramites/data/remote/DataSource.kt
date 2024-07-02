package com.example.kmmtramites.data.remote

class DataSource(
    private val tramiteService: TramiteService,
    private val entidadService: EntidadService,
    private val viewService: ViewService
) {
    suspend fun getListTramite(correlativo: String) = tramiteService.getAllTramite(correlativo)

    suspend fun getEntidadForCorrelativo(correlativo: String) =
        entidadService.findForCorrelativo(correlativo)

    suspend fun getEntidadForTramite(tramite: String) = entidadService.findForTramite(tramite)

    suspend fun getListView(correlativo: String, tramite: String) =
        viewService.getAllView(correlativo, tramite)
}