package com.letsstartcoding.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;
import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.repository.EmployeeRepository;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		
		return employeeDAO.save(emp);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignatoion(empDetails.getDesignatoion());
		emp.setExperties(empDetails.getExperties());
		emp.setDepartment(empDetails.getDepartment());
		Employee updateEmployee=employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
	
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	 @GetMapping(value = "/name/{text}")
	    public List<Employee> searchName(@PathVariable final String text) {
	        return employeeRepository.findByName(text);
	    }
	
}
