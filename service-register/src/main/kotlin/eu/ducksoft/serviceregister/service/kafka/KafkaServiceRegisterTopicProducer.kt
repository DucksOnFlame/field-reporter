package eu.ducksoft.serviceregister.service.kafka

import eu.ducksoft.serviceregister.service.ServiceRecord
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

const val SERVICE_REGISTER_TOPIC: String = "ServiceRegisterTopic"

@Service
class KafkaServiceRegisterTopicProducer(
        private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendServiceRegisteredEvent(serviceRecord: ServiceRecord) {
        kafkaTemplate.send(SERVICE_REGISTER_TOPIC,
                "Service registered! name: ${serviceRecord.name}, url: ${serviceRecord.url}")
    }
}