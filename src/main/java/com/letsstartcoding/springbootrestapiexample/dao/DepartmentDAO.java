package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Department;
import com.letsstartcoding.springbootrestapiexample.repository.DepartmentRepository;

@Service
public class DepartmentDAO {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department save(Department dept) {
		return departmentRepository.save(dept);
		
	}
	
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
	public Department findOne(Long deptid) {
		return departmentRepository.findOne(deptid);
	}

	/* delete an employee */

	public void delete(Department dept) {
		departmentRepository.delete(dept);
	}
	
}
