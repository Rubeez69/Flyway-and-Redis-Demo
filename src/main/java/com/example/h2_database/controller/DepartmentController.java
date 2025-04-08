package com.example.h2_database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2_database.entity.Department;
import com.example.h2_database.service.DepartmentService;
@RestController
public class DepartmentController {
	@Autowired private DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@Validated @RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		return departmentService.fetchDepartmentList();
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long id) {
		return departmentService.updateDepartment(department, id);			
	}
	
	@DeleteMapping("/departments/{id}")
	public void deleteDepartment(@PathVariable("id") Long id) {
		departmentService.deleteDepartmentById(id);
	}
}
