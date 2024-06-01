package com.microservice.employeeservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservice.employeeservice.model.Employee;

@Repository
public class EmpRepository {
	
	private List<Employee> employees = new ArrayList<>();

	public Employee addEmployee(Employee dep) {
		employees.add(dep);
		return dep;
	}

	public Employee findbyID(Long id) {
		return employees.stream().filter(emp -> emp.id().equals(id)).findFirst().orElseThrow();
	}

	public List<Employee> findAll() {
		return employees;
	}
	
	public List<Employee> findbyDepID(Long id) {
		return employees.stream().filter(emp -> emp.depId().equals(id)).toList();
	}

}
