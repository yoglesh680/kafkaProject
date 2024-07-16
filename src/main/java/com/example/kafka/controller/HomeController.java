//package com.example.kafka.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.kafka.producer.Producer;
//
//@RestController
//@RequestMapping("/api/v1/kafka")
//public class HomeController {
//
//	@Autowired
//	Producer producer;
//
//	public HomeController(Producer producer) {
//		this.producer = producer;
//	}
//
//	@GetMapping("/publishs")
//	public ResponseEntity<String> publish(@RequestParam("message") String message) {
//		producer.sendMessage(message);
//		return ResponseEntity.ok("Message sent to the topic");
//	}
//
//}
