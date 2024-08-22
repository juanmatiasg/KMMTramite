package com.example.kmmtramites

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.ProxyBuilder
import io.ktor.client.engine.ProxyType
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.client.statement.HttpReceivePipeline
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.HttpResponseContainer
import io.ktor.client.statement.HttpResponsePipeline
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun initLogger()

expect fun createHttpClient(): HttpClient

fun HttpClientConfig<*>.applyCommonConfig() {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }




    install(HttpTimeout) {
        requestTimeoutMillis = 30000  // Tiempo de espera de la solicitud en milisegundos
        connectTimeoutMillis = 10000  // Tiempo de espera de la conexión en milisegundos
        socketTimeoutMillis = 10000   // Tiempo de espera del socket en milisegundos
    }


    install(Logging) {
        level = LogLevel.ALL
        logger = object : Logger {
            override fun log(message: String) {
                Napier.v(tag = "HttpClient", message = message)
            }
        }
    }.also {
        initLogger()
    }
}






