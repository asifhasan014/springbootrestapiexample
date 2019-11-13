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

import com.letsstartcoding.springbootrestapiexample.dao.DepartmentDAO;
import com.letsstartcoding.springbootrestapiexample.model.Department;
import com.letsstartcoding.springbootrestapiexample.repository.DepartmentRepository;

@RestController
@RequestMapping("/companydepartment")
public class DepartmentController {
	
    @Autowired
	DepartmentDAO departmentDAO;
    
    @Autowired
    DepartmentRepository departmentRepository;
    
    @PostMapping("/department")
	public Department createDepartment(@Valid @RequestBody Department dept) {
		
		return departmentDAO.save(dept);
	}
    @GetMapping("/department")
	public List<Department> getAllEmployees(){
		return departmentRepository.findAll();
	}
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getEmployeeById(@PathVariable(value="id") Long deptid){
		
		Department dept=departmentDAO.findOne(deptid);
		
		if(dept==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dept);
		
	}
	@PutMapping("/department/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(value="id") Long deptid,@Valid @RequestBody Department deptDetails){
		
		Department dept=departmentDAO.findOne(deptid);
		if(dept==null) {
			return ResponseEntity.notFound().build();
		}
		
		dept.setDept_name(deptDetails.getDept_name());
		dept.setDept_salary(deptDetails.getDept_salary());
		//dept.setEmployee(deptDetails.getEmployee());
		Department updateDepartment=departmentDAO.save(dept);
		return ResponseEntity.ok().body(updateDepartment);
	
	}
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable(value="id") Long deptid){
		
		Department dept=departmentDAO.findOne(deptid);
		if(dept==null) {
			return ResponseEntity.notFound().build();
		}
		departmentDAO.delete(dept);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	
}
