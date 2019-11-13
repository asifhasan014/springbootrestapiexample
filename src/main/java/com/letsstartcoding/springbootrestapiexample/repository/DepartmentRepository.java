package com.letsstartcoding.springbootrestapiexample.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.letsstartcoding.springbootrestapiexample.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

	
}



