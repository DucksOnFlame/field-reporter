package eu.ducksoft.taskservice.service.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

const val SERVICE_REGISTER_TOPIC: String = "ServiceRegisterTopic"

@Service
class ServiceRegistryEventKafkaListener {

    private val logger: Logger = LoggerFactory.getLogger(ServiceRegistryEventKafkaListener::class.java)

    @KafkaListener(topics = [SERVICE_REGISTER_TOPIC], groupId = "1")
    fun onServiceRegisteredEvent(message: String) {
        logger.info("Received Message in group foo: $message")
    }
}