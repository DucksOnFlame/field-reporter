package eu.ducksoft.taskservice.service.kafka

import eu.ducksoft.serviceregister.client.kafka.AbstractKafkaConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@Configuration
class DataFetcherKafkaConfig(
        @Value("\${kafka.bootstrapAddress}") private val bootstrapAddress: String,
        @Value("\${kafka.serviceRegister.groupId}") private val groupId: String
) : AbstractKafkaConfig(bootstrapAddress, groupId)