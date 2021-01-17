package com.furnitureshop.app.v1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class CartEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne()
	@JoinColumn(name="customer_id") //??
	private CustomerEntity customerId;

	
	
	public CartEntity() {

	}



	public CartEntity(Long id, CustomerEntity customerId) {
		super();
		this.id = id;
		this.customerId = customerId;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public CustomerEntity getCustomerId() {
		return customerId;
	}



	public void setCustomerId(CustomerEntity customerId) {
		this.customerId = customerId;
	}
	
	
	

	

}
