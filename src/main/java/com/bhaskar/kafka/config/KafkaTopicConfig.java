package com.bhaskar.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    //bhaskar here is Topic Name which will be used while sending and receiving data
    @Bean
    public NewTopic bhaskarTopic() {
        return TopicBuilder.name("bhaskar").build();
    }
}
