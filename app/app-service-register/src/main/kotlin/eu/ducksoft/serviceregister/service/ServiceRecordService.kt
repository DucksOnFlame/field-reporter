package eu.ducksoft.serviceregister.service

import eu.ducksoft.serviceregister.infrastructure.ServiceRecordEntity
import eu.ducksoft.serviceregister.infrastructure.ServiceRecordRepository
import eu.ducksoft.serviceregister.service.kafka.KafkaServiceRegisterTopicProducer
import org.springframework.stereotype.Service
import java.util.*

@Service
class ServiceRecordService(
        private val repository: ServiceRecordRepository,
        private val kafkaProducer: KafkaServiceRegisterTopicProducer
) {

    fun updateServiceRecord(name: String, url: String) {
        val record: ServiceRecordEntity = repository.findById(name)
                .map {
                    it.url = url
                    it
                }
                .orElseGet { ServiceRecordEntity(name, url) }
        repository.save(record)
        kafkaProducer.sendServiceRegisteredEvent(toDomain(record))
    }

    fun getAllServices(): List<ServiceRecord> {
        return repository.findAll()
                .map(this::toDomain)
    }

    fun findService(serviceName: String): Optional<ServiceRecord> {
        return repository.findById(serviceName)
                .map(this::toDomain)
    }

    private fun toDomain(entity: ServiceRecordEntity): ServiceRecord {
        return ServiceRecord(entity.name, entity.url)
    }
}