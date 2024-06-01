package com.microservice.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.employeeservice.model.Employee;
import com.microservice.employeeservice.repository.EmpRepository;


@RestController
@RequestMapping("/employee")
public class EmpController {

	
	private final static Logger LOGGER = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpRepository empRepo;
	
	@PostMapping("/addemp")
	public Employee addEmployee(@RequestBody Employee emp) {
		LOGGER.info("Add Emp", emp);
		return empRepo.addEmployee(emp);
	}
	
	@GetMapping("/getemp/{id}")
	public Employee getEmployeebyID(@PathVariable Long id) {
		LOGGER.info("Get emp", id);
		return empRepo.findbyID(id);
		
	}

	@GetMapping("/getemp/dep/{id}")
	public List<Employee> getEmployeebydepID(@PathVariable Long id) {
		LOGGER.info("Get emp", id);
		return empRepo.findbyDepID(id);
		
	}
	@GetMapping("/getallemp")
	public List<Employee> getemployees(){
		LOGGER.info("Get All emps");
		return empRepo.findAll();
	}


}
