//package com.example.scheduler.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.scheduler.entity.Employee;
//import com.example.scheduler.repository.EmployeeRepository;
//
//@Service
//
//public class EmployeeServiceImpl implements EmployeeService {
//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	@Override
//	public List<Employee> getAllEmployee() {
//		return employeeRepository.findAll();
//	}
//
//	@Override
//
//	public Employee getEmployee(int id) {
//
//		Employee value = employeeRepository.findById(id);
//
//		return value;
//	}
//
//	@Override
//	public Employee saveEmployee(Employee employee) {
//		return employeeRepository.save(employee);
//	}
//
//	@Override
//	public void deleteEmployee(int id) {
//
//		employeeRepository.deleteById(id);
//	}
//
//}
