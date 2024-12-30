package com.foodics.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class KtorClientFactory(private val config: NetworkConfig) {

    fun createClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
            defaultRequest {
                url(config.baseUrl)
                header("Content-Type", Json.toString())
            }
            engine {
                connectTimeout = 30_000
                socketTimeout = 30_000
            }
        }
    }
}
