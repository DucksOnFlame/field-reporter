package eu.ducksoft.serviceregister.client.http

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*

class ServiceRegisterHttpClientFactory {
    companion object {
        fun getClient(): HttpClient {
            return HttpClient(CIO) {
                install(JsonFeature) {
                    serializer = GsonSerializer {
                        // Configurable .GsonBuilder
                        serializeNulls()
                        disableHtmlEscaping()
                    }
                }
                engine {
                    threadsCount = 1
                    maxConnectionsCount = 1
                    endpoint {
                        keepAliveTime = 30000
                        connectTimeout = 30000
                    }
                }
            }
        }
    }
}