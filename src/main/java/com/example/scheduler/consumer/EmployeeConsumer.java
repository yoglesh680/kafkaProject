package com.example.scheduler.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.scheduler.entity.Employee;

@Service
public class EmployeeConsumer {
	@KafkaListener(topics = "Topic1", groupId = "top", containerFactory = "kafkaJsonListenerContainerFactory",concurrency = "10")
	public void consume(Employee employee) {
		System.out.println(String.format("message recieved from EmployeeConsumer-> %s", employee.toString()));

	}
}
