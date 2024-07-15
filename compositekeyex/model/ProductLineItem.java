package com.techgatha.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class ProductLineItem implements Serializable{

	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	@ManyToOne(cascade = CascadeType.ALL)
	private Order order;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
