package com.microservice.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservice.departmentservice.model.Department;

@Repository
public class DepartmentRepository {

	private List<Department> departments = new ArrayList<>();

	public Department addDepartment(Department dep) {
		departments.add(dep);
		return dep;
	}

	public Department findbyID(Long id) {
		return departments.stream()
				.filter(dep -> dep.getId().equals(id))
				.findFirst().orElseThrow();
	}
	
	public List<Department> findAll(){
		return departments;
	}

}
