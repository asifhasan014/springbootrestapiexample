package com.letsstartcoding.springbootrestapiexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeApplication {
//this is our main class
	public static void main(String[] args) {
		
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
