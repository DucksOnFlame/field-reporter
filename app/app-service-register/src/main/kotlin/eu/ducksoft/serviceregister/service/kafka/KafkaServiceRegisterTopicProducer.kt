package eu.ducksoft.serviceregister.service.kafka

import eu.ducksoft.eventregistry.events.ServiceRegisteredEvent
import eu.ducksoft.eventregistry.topics.SERVICE_REGISTER_TOPIC
import eu.ducksoft.serviceregister.service.ServiceRecord
import eu.ducksoft.utils.core.json.GsonSerializer.Companion.toJson
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaServiceRegisterTopicProducer(
        private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendServiceRegisteredEvent(serviceRecord: ServiceRecord) {
        val event = ServiceRegisteredEvent(serviceRecord.name, serviceRecord.url)
        kafkaTemplate.send(SERVICE_REGISTER_TOPIC, toJson(event))
    }
}