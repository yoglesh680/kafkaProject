package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic createTopic() {
		return TopicBuilder.name("Topic1").partitions(1).build();
	}

	@Bean
	public NewTopic createTopic1() {
		return TopicBuilder.name("input").partitions(1).build();
	}

	@Bean
	public NewTopic createTopic12() {
		return TopicBuilder.name("test").partitions(1).build();
	}

}
