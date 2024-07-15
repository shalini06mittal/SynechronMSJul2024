package com.techgatha.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private Date date;
	@ManyToOne(optional = false)
	@JoinColumn(name="custid")
	private Customer customer;
	
	@OneToMany(mappedBy = "primaryKey.order", cascade = CascadeType.ALL)
	private List<LineItem> lineitems = new  ArrayList<LineItem>();

	public List<LineItem> getLineitems() {
		return lineitems;
	}

	public void setLineitems(List<LineItem> lineitems) {
		this.lineitems = lineitems;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customers) {
		this.customer = customers;
	}

	public void calculate()
	{
		List<LineItem> items = getLineitems();
		System.out.println("========================================================");
		System.out.println("Order No\tDate");
		System.out.println("========================================================");
		System.out.println(getOrderid()+"\t\t"+getDate());
		System.out.println("--------------------------------------------------------");
		System.out.println("Product\t\tQuantity\tPrice\tAmount");
		System.out.println("========================================================");
		double total = 0.0;
		for(LineItem item:items)
		{
			double cost = item.getproduct().getPrice() * item.getQty(); 
			System.out.println(item.getproduct().getPname()+"\t\t"+item.getQty()+"\t\t"+item.getproduct().getPrice()+"\t"+cost);
			System.out.println("--------------------------------------------------------");
			total += cost;
		}
		System.out.println("Total : \t\tRs."+total);
	}
	

	
	
	
}
