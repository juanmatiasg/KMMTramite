package com.example.kmmtramites

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
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






