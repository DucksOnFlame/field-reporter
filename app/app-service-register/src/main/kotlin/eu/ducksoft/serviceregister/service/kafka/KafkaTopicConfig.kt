package eu.ducksoft.serviceregister.service.kafka

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class KafkaTopicConfig {

    @Bean
    fun serviceRegisterTopic(): NewTopic {
        return NewTopic(SERVICE_REGISTER_TOPIC, 1, 1.toShort())
    }
}