package com.example.scheduler.controller;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.scheduler.entity.Employee;

@RestController
@RequestMapping(produces = "application/json")
public class HomeController {
	RestTemplate restTemplate = new RestTemplate();

	@SuppressWarnings("unchecked")
	@GetMapping("/employee")
	ResponseEntity<Employee[]> getEmployees() throws URISyntaxException {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("employee", headers);
		String uri = "http://localhost:8080/get";
		ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity,
				Employee[].class);
		System.out.println(responseEntity);
		return responseEntity;
	}

//S
//	@GetMapping("/employeeId")
//	Employee getDetail(@PathVariable int id) {
//		return employeeService.getEmployee(id);
//
//	}
//
//	@PostMapping("/employee")
//	Employee save(@RequestBody Employee employee) {
//		return employeeService.saveEmployee(employee);
//
//	}
//
//	@DeleteMapping("/employee")
//	public String deleteEmployee(@PathVariable int id) {
//		employeeService.deleteEmployee(id);
//		return "Id Deleted Successfully";
//
//	}
//
//	@Scheduled(fixedRate = 3000)
//	public void getMessage() {
//		System.out.println("3 second new Date" + new Date());
//	}
//
//	@Scheduled(fixedRate = 5000)
//	public void getMessage1() {
//		System.out.println("5  second new Date" + new Date());
//	}
}
