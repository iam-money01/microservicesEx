package com.microservice.departmentservice.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.microservice.departmentservice.model.Employee;


@HttpExchange
public interface EmpClient {
	
	@GetExchange("/employee/getemp/dep/{id}")
	public List<Employee> getEmployeebydepID(@PathVariable Long id) ;

	
}
