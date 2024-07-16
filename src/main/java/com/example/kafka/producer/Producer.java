package com.example.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	public Producer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Scheduled(fixedRate = 10000)
	public void sendMessage() {
		String message = "hello";
		LOGGER.info(String.format("Message sent %s ", message));
		kafkaTemplate.send("test", message);
	}

}
