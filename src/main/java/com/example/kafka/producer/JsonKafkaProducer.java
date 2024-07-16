package com.example.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.kafka.entity.Employee;
import com.example.kafka.repository.EmployeeRepo;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, Employee> kafkaTemplate;

	@Autowired
	EmployeeRepo employeeRepo;

	public JsonKafkaProducer(KafkaTemplate<String, Employee> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(Employee employee) {

		LOGGER.info(String.format("Message sent -> %s", employee.toString()));
		Message<Employee> message = MessageBuilder.withPayload(employee).setHeader(KafkaHeaders.TOPIC, "Topic1")
				.build();

		kafkaTemplate.send(message);
	}
}