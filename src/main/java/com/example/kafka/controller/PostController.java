package com.example.kafka.controller;

import java.util.List;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.entity.Address;
import com.example.kafka.entity.Employee;
import com.example.kafka.producer.AddressProducer;
import com.example.kafka.producer.JsonKafkaProducer;
import com.example.kafka.repository.AddressRepo;
import com.example.kafka.repository.EmployeeRepo;

@RestController
public class PostController {
	@Autowired
	private JsonKafkaProducer kafkaProducer;

	@Autowired
	private AddressProducer addressProducer;

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	AddressRepo addressRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	public PostController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@Scheduled(fixedRate = 5000)
	public void run() {
		String message = "";
		publish();
		publishAddress();
		LOGGER.info(String.format("Message sent %s ", message));

	}

	@GetMapping("/publish")
	public String publish() {
		List<Employee> list = employeeRepo.findAll();
		for (Employee employee2 : list) {
			kafkaProducer.sendMessage(employee2);
		}

		return "Json message sent to kafka topic";
	}

	@GetMapping("/publishAdddress")
	public String publishAddress() {
		List<Address> list = addressRepo.findAll();
		for (Address address : list) {
			addressProducer.sendMessage(address);
		}

		return "Json message sent to kafka topic";
	}
//	@GetMapping(value = "/get", headers = "Accept=application/json")
//	public List<Employee> publish() {
//		List<Employee> list = employeeRepo.findAll();
////		for (Employee employee2 : list) {
////			kafkaProducer.sendMessage(employee2);
////		}
//
//		return list;
//	}

}
