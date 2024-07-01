package com.example.kmmtramites.data.remote

import com.example.kmmtramites.initLogger
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders.Connection
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


abstract class KtorApi {

    private val BASE_URL = "https://10.0.2.2:7044"


    val client = HttpClient(CIO) {


        install(WebSockets)

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }




        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HttpClient", message = message)
                }
            }
            Logger
        }.also {
            initLogger()
        }

    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
            accept(ContentType.Application.Json)
        }
    }


}
