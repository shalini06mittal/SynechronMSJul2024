package com.techgatha.model;

import java.beans.Transient;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverrides({
	@AssociationOverride(name =  "primaryKey.prod",
			joinColumns = @JoinColumn(name="prodid")),
	@AssociationOverride(name =  "primaryKey.order",
	joinColumns = @JoinColumn(name="orderid"))
})
public class LineItem {
	
	@EmbeddedId
	private ProductLineItem primaryKey = new ProductLineItem();
	
	private int qty;
	

	public ProductLineItem getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(ProductLineItem primaryKey) {
		this.primaryKey = primaryKey;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void setOrder(Order order)
	{
		getPrimaryKey().setOrder(order);
	}
	@Transient
	public Order getOrder()
	{
		return getPrimaryKey().getOrder();
	}
	public void setProduct(Product product)
	{
		getPrimaryKey().setProduct(product);
	}
	@Transient
	public Product getproduct()
	{
		return getPrimaryKey().getProduct();
	}
	
	
}
