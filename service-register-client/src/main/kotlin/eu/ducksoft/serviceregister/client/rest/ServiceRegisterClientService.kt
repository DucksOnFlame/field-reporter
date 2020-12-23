package eu.ducksoft.serviceregister.client.rest

import eu.ducksoft.serviceregister.client.http.ServiceRegisterHttpClientFactory
import eu.ducksoft.serviceregister.client.rest.request.UpdateServiceRecordRequest
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class ServiceRegisterClientService(
        private val serviceRegisterUrl: String,
        private val serviceUrl: String,
        private val serviceName: String) {

    private val logger: Logger = LoggerFactory.getLogger(ServiceRegisterClientService::class.java)

    private val httpClient: HttpClient = ServiceRegisterHttpClientFactory.getClient()

    init {
        runBlocking {
            registerInServiceRegister()
        }
    }

    private suspend fun registerInServiceRegister() {
        logger.info("Registering service $serviceName with url $serviceUrl in ServiceRegistry...")
        httpClient.put<HttpResponse>("$serviceRegisterUrl/service/$serviceName") {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            body = UpdateServiceRecordRequest(serviceUrl)
            port = 9090
        }
        logger.info("Service $serviceName with url $serviceUrl registered in ServiceRegistry!")
    }
}