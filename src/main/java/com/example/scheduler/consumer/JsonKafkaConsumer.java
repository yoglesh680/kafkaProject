package com.example.scheduler.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.scheduler.entity.Address;

@Service
public class JsonKafkaConsumer {

	@KafkaListener(topics = "Topic1", groupId = "top", containerFactory = "addressKafkaJsonListenerContainerFactory",concurrency = "10")
	public void consume(Address address) {
		System.out.println(String.format("message recieved from -> %s", address.toString()));

	}
}
