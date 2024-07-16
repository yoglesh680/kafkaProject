package com.example.scheduler.config;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.scheduler.entity.Employee;

@Configuration
@EnableKafka
public class Config {
	@SuppressWarnings("rawtypes")
	@Bean
	public ConsumerFactory<String, Employee> consumerFactory() {

		Properties props = new Properties();

		props.put("bootstrap.servers", "localhost:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "top1");
		props.put("message.assembler.buffer.capacity", 33554432);
		props.put("max.tracked.messages.per.partition", 24);
		props.put("exception.on.message.dropped", true);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, com.example.scheduler.entity.Employee.class);
		return new DefaultKafkaConsumerFactory(props, null, new StringDeserializer());
	}

	@Bean
	public KafkaListenerContainerFactory<?> kafkaJsonListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Employee> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setMessageConverter(new StringJsonMessageConverter());
		return factory;

	}
}
