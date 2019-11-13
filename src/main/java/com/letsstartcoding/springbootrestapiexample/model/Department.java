package com.letsstartcoding.springbootrestapiexample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Department")
@EntityListeners(AuditingEntityListener.class)
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  dept_id;
	
	@NotBlank
	private String dept_name;
	
	@NotBlank
	private String dept_salary;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "Department")
	private List<Employee> Employee;

	public List<Employee> getEmployee() {
		return Employee;
	}

	public void setEmployee(List<Employee> employee) {
		Employee = employee;
	}

	public long getDept_id() {
		return dept_id;
	}

	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_salary() {
		return dept_salary;
	}

	public void setDept_salary(String dept_salary) {
		this.dept_salary = dept_salary;
	}

	

	
	
}
