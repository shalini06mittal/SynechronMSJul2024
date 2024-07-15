package com.synechron.web.SpringBootRestDemo;// root package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import com.synechron.web.SpringBootRestDemo.entity.Employee;
import com.synechron.web.SpringBootRestDemo.service.EmployeeService;
//jdbc:h2:mem:94477974-c1ad-4e4a-81c6-275dd0eb5b8e
/**
 * Basic CRUD Operations
 * 
 * CrudRepository
 * PagingAndSortingRepository
 * JpaRepository
 * @author Shalini
 *
 */
@SpringBootApplication
//@ComponentScan("demo")
public class SpringBootRestDemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = 
		SpringApplication.run(SpringBootRestDemoApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		System.out.println(employeeService.getEmployeeCount());
	}
}
