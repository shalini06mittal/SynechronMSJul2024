package com.synechron.web.SpringBootRestDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.synechron.web.SpringBootRestDemo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	// custom methods
	public List<Employee> findByCity(String city);
}
