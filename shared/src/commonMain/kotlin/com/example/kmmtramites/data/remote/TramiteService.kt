package com.example.kmmtramites.data.remote

import com.example.kmmtramites.data.model.TramiteData
import com.example.kmmtramites.data.model.TramiteResponse
import com.example.kmmtramites.domain.model.Tramite
import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class TramiteService : KtorApi() {
    suspend fun getAllTramite(correlativo: String): List<Tramite> {
        try {
            val response = client.get {
                pathUrl("/api/Tramite/TramitesPorCorrelativo")
                parameter("correlativo", correlativo)

            }.body<TramiteResponse>()


           val responseBody = client.get {
                pathUrl("/api/Tramite/TramitesPorCorrelativo")
                parameter("correlativo", correlativo)

            }.body<String>()

            println(responseBody)


            return response.data.map { it.toDomain() }

        } catch (e: Exception) {
            Napier.e("Request failed with exception", e)
            throw e
        } finally {
            client.close()
        }
    }


    private fun TramiteData.toDomain(): Tramite {
        return Tramite(
            numero = this.numero,
            descripcion = this.descripcion,
            destinoActual = this.destinoActual,
            fechaInicioTramite = this.fechaInicioTramite,
            fechaDestinoActual = this.fechaDestinoActual,
            tieneVista = this.tieneVista
        )

    }


}