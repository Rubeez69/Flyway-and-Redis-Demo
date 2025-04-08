package com.example.h2_database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.h2_database.entity.Department;

@Repository

public interface DepartmentRepository extends CrudRepository<Department, Long>{
	
}
