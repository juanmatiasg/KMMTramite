package com.example.kmmtramites.data.remote

import com.example.kmmtramites.Config
import com.example.kmmtramites.createHttpClient
import com.example.kmmtramites.data.model.ViewData
import com.example.kmmtramites.data.model.ViewResponse
import com.example.kmmtramites.domain.model.View
import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ViewService:KtorApi() {
    suspend fun getAllView(correlativo: String, tramite: String): List<View> {

        val client = createHttpClient()

        try {
            val response = client.get {
                pathUrl(Config.ENDPOINT_VIEW)
                parameter ("correlativo", correlativo)
                parameter("tramite", tramite)

            }.body<ViewResponse>()


            return response.data.map { it.toDomain() }

        } catch (e: Exception) {
            Napier.e("Request failed with exception", e)
            throw e
        } catch (e: HttpRequestTimeoutException) {
            Napier.e("Request failed with HttpRequestTimeoutException", e)
            throw e
        } finally {
            client.close()
        }
    }


    private fun ViewData.toDomain(): View {
        return View(
            inicioTramite = this.inicioTramite,
            inicioVista = this.inicioVista,
            inspector = this.inspector,
            detalle = this.detalle
        )

    }
}