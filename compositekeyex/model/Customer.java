package com.techgatha.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String username;
	private String custname;
	private String password;
	private String city;
	private String phone;

	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String custname, String password, String city, String phone, String username) {
		super();
		this.custname = custname;
		this.password = password;
		this.city = city;
		this.phone = phone;
		this.username = username;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Customer [custname=" + custname + ", password=" + password + ", city=" + city + ", phone=" + phone
				+ ", username=" + username + "]";
	}
	
	
}
