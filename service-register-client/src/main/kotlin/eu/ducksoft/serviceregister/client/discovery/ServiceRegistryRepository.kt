package eu.ducksoft.serviceregister.client.discovery

import eu.ducksoft.serviceregister.client.rest.ServiceRegisterClientService
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Service
class ServiceRegistryRepository(private val client: ServiceRegisterClientService) {

    private val cache: MutableMap<String, Optional<String>> = ConcurrentHashMap()

    fun putToCache(serviceName: String, serviceUrl: String) {
        cache[serviceName] = Optional.of(serviceUrl)
    }

    fun getUrlForService(serviceName: String): Optional<String> {
        return cache.computeIfAbsent(serviceName) {
            runBlocking {
                client.getServiceUrlByName(serviceName)
                        .map { it.url }
            }
        }
    }
}