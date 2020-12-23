package eu.ducksoft.taskservice.rest.serviceregister

import eu.ducksoft.serviceregister.client.rest.ServiceRegisterClientService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class DataFetcherServiceRegisterClientService(
        @Value("\${service.register.url}") private val serviceRegisterUrl: String,
        @Value("\${service.url}") private val serviceUrl: String,
        @Value("\${service.name}") private val serviceName: String
) : ServiceRegisterClientService(serviceRegisterUrl, serviceUrl, serviceName)