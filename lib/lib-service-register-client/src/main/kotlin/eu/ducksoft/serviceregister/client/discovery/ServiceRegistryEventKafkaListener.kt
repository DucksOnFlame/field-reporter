package eu.ducksoft.serviceregister.client.discovery

import eu.ducksoft.eventregistry.events.ServiceRegisteredEvent
import eu.ducksoft.eventregistry.topics.SERVICE_REGISTER_TOPIC
import eu.ducksoft.utils.core.json.GsonSerializer.Companion.fromJson
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ServiceRegistryEventKafkaListener(private val serviceRegistryRepository: ServiceRegistryRepository) {

    private val logger: Logger = LoggerFactory.getLogger(ServiceRegistryEventKafkaListener::class.java)

    @KafkaListener(topics = [SERVICE_REGISTER_TOPIC], groupId = "1")
    fun onServiceRegisteredEvent(eventString: String) {
        val event: ServiceRegisteredEvent = fromJson(eventString, ServiceRegisteredEvent::class.java)
        logger.info("Received ServiceRegisteredEvent: ${event.serviceName}, ${event.serviceUrl}")
        serviceRegistryRepository.putToCache(event.serviceName, event.serviceUrl)
    }
}