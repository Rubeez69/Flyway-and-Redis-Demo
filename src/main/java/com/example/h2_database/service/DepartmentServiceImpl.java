package com.example.h2_database.service;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.example.h2_database.entity.Department;
import com.example.h2_database.repository.DepartmentRepository;

import ch.qos.logback.classic.Logger;
import jakarta.websocket.server.ServerEndpoint;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	private static final Logger logger = (Logger) LoggerFactory.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Override
	@CachePut(value= "departments", key= "#department.departmentId")
	@CacheEvict(value= "departmentsList", allEntries = true)
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	@Cacheable(value= "departmentsList")
	public List<Department> fetchDepartmentList() {
		logger.info("Fetching from DB...");
		return (List<Department>) departmentRepo.findAll();
	}

	@Override
	@CachePut(value= "departments", key= "#id")
	@CacheEvict(value= "departmentsList", allEntries = true)
	public Department updateDepartment(Department department, Long id) {
		Department departDB = departmentRepo.findById(id).orElseThrow(()-> new RuntimeException("Department not found!"));
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			departDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			departDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			departDB.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepo.save(departDB);
	}

	@Override
	@Caching(evict= {@CacheEvict(value= "departments", key= "#id"),
	@CacheEvict(value= "departmentsList", allEntries = true)})
	
	public void deleteDepartmentById(Long id) {
		// TODO Auto-generated method stub
		departmentRepo.deleteById(id);
	}

}
