package com.microservice.departmentservice.controller;

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

import com.microservice.departmentservice.client.EmpClient;
import com.microservice.departmentservice.model.Department;
import com.microservice.departmentservice.repository.DepartmentRepository;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository depRepo;
	
	@Autowired
	private EmpClient empClient;
	
	@PostMapping("/adddepartment")
	public Department addDepartment(@RequestBody Department dep) {
		LOGGER.info("Add department", dep);
		return depRepo.addDepartment(dep);
	}
	
	@GetMapping("/getdepartment/{id}")
	public Department getDepartment(@PathVariable Long id) {
		LOGGER.info("Get department", id);
		return depRepo.findbyID(id);
		
	}

	@GetMapping("/getalldep")
	public List<Department> getDepartments(){
		LOGGER.info("Get All departments");
		return depRepo.findAll();
	}
	
	@GetMapping("/getalldep/with-emp")
	public List<Department> getDepartwithEmp(){
		LOGGER.info("Get All departments with emp");
	    List< Department> departments = depRepo.findAll();
	    departments.forEach(dep-> dep.setEmployees(empClient.getEmployeebydepID(dep.getId())));
	    return departments;
	    
	}
}
