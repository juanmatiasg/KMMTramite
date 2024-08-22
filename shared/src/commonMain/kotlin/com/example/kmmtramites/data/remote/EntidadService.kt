package com.example.kmmtramites.data.remote

import com.example.kmmtramites.Config
import com.example.kmmtramites.data.model.Data
import com.example.kmmtramites.data.model.EntidadResponse
import com.example.kmmtramites.domain.model.Entidad
import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class EntidadService:KtorApi() {
    suspend fun findForCorrelativo(correlativo: String): Entidad {

        try {
            val response = client.get {
                pathUrl(Config.ENDPOINT_ENTIDAD_CORRELATIVO)
                parameter("correlativo", correlativo)

            }.body<EntidadResponse>()

            if (response.isSuccess) {
                return response.data.toDomain()
            } else {
                throw Exception("Server returned ${response.message}")
            }

        } catch (e: Exception) {
            Napier.e("Request failed with exception", e)
            throw e
        } catch (e: HttpRequestTimeoutException) {
            Napier.e("Request failed with HttpRequestTimeoutException", e)
            throw e
        }


    }

    suspend fun findForTramite(tramite: String): Entidad {

        try {
            val response = client.get {
                pathUrl(Config.ENDPOINT_ENTIDAD_TRAMITE)
                parameter("tramite", tramite)

            }.body<EntidadResponse>()

            return response.data.toDomain()

        } catch (e: Exception) {
            Napier.e("Request failed with exception", e)
            throw e
        } catch (e: HttpRequestTimeoutException){
            Napier.e("Request failed with HttpRequestTimeoutException", e)
            throw e
        }

    }


    private fun Data.toDomain(): Entidad {
        return Entidad(
            razonSocial, tipoSocietario, correlativo
        )

    }
}