package eu.ducksoft.serviceregister.service.kafka

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin


@Configuration
class KafkaTopicConfig(
        @Value(value = "\${kafka.bootstrapAddress}") private val bootstrapAddress: String
) {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        return KafkaAdmin(configs)
    }

    @Bean
    fun serviceRegisterTopic(): NewTopic {
        return NewTopic(SERVICE_REGISTER_TOPIC, 1, 1.toShort())
    }
}