package com.synechron.web.SpringBootRestDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.synechron.web.SpringBootRestDemo.entity.Employee;
import com.synechron.web.SpringBootRestDemo.entity.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer> {
	

}
