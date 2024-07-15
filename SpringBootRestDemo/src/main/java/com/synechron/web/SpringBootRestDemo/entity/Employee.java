package com.synechron.web.SpringBootRestDemo.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity// database managed entity
@Table(name="emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id// auto-increment
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name ="empname", length = 100)
	private String name;
	@Column(name="city")
	private String city;
	private String country;
	
//	@OneToOne
//	@JoinColumn(name="laptopid")
//	private Laptop laptop;
	
//	@OneToMany(mappedBy = "employee")
//	private List<Laptop> laptop;
}
