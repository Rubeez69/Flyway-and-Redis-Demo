package com.example.h2_database.service;

import java.util.List;

import com.example.h2_database.entity.Department;

public interface DepartmentService {
	Department saveDepartment(Department department);
	List<Department> fetchDepartmentList();
	Department updateDepartment(Department department, Long id);
	void deleteDepartmentById(Long id);
}
