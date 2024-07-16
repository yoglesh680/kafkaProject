package com.example.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.kafka.entity.Address;
import com.example.kafka.repository.EmployeeRepo;

@Service
public class AddressProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, Address> kafkaTemplate;

	@Autowired
	EmployeeRepo employeeRepo;

	public AddressProducer(KafkaTemplate<String, Address> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(Address address) {

		LOGGER.info(String.format("Message sent -> %s", address.toString()));
		Message<Address> message = MessageBuilder.withPayload(address).setHeader(KafkaHeaders.TOPIC, "Topic1").build();
       
		kafkaTemplate.send(message);
	}
}
