package com.example.kmmtramites.data.remote

import com.example.kmmtramites.Config
import com.example.kmmtramites.createHttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.accept
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.path
import io.ktor.http.takeFrom



abstract class KtorApi {

    val client = createHttpClient()

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(Config.BASE_URL)
            path(path)

        }
    }
}