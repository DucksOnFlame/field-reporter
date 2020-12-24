package eu.ducksoft.serviceregister.client.rest

import eu.ducksoft.serviceregister.client.discovery.dto.ServiceRecordDTO
import eu.ducksoft.serviceregister.client.rest.request.UpdateServiceRecordRequest
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class ServiceRegisterClientService(
        @Value("\${service.register.url}") private val serviceRegisterUrl: String,
        @Value("\${service.url}") private val serviceUrl: String,
        @Value("\${service.name}") private val serviceName: String): InitializingBean {

    private val logger: Logger = LoggerFactory.getLogger(ServiceRegisterClientService::class.java)

    private val httpClient: HttpClient = ServiceRegisterHttpClientFactory.getClient()

    override fun afterPropertiesSet() {
        runBlocking {
            registerInServiceRegister()
        }
    }

    suspend fun getServiceUrlByName(serviceName: String): Optional<ServiceRecordDTO> {
        val result: ServiceRecordDTO? = httpClient.get("$serviceRegisterUrl/service/$serviceName") {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }

        return Optional.ofNullable(result)
    }

    private suspend fun registerInServiceRegister() {
        logger.info("Registering service $serviceName with url $serviceUrl in ServiceRegistry...")
        httpClient.put<Unit>("$serviceRegisterUrl/service/$serviceName") {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            body = UpdateServiceRecordRequest(serviceUrl)
        }
        logger.info("Service $serviceName with url $serviceUrl registered in ServiceRegistry!")
    }
}