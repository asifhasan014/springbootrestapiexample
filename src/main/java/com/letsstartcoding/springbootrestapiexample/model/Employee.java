package com.letsstartcoding.springbootrestapiexample.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Employeetable")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String designatoion;
	
	@NotBlank
	private String experties;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Department Department;
	
	
	public Employee() {
		
	}
	public Employee(String name, String designatoion, String experties,Department department) {
		this.name = name;
		this.designatoion = designatoion;
		this.experties = experties;
		Department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignatoion() {
		return designatoion;
	}

	public void setDesignatoion(String designatoion) {
		this.designatoion = designatoion;
	}

	public String getExperties() {
		return experties;
	}

	public void setExperties(String experties) {
		this.experties = experties;
	}
	public Department getDepartment() {
		return Department;
	}
	public void setDepartment(Department department) {
		Department = department;
	}
	


	
	
	
	
}
