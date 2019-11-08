package com.letsstartcoding.springbootrestapiexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsstartcoding.springbootrestapiexample.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByName(String text);
}
