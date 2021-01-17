package com.furnitureshop.app.v1.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="customer_order") // renamed since order is reserved word in SQL
//
public class OrderEntity { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false) // ?
	@JoinColumn(name="customer_id")
	@OnDelete(action = OnDeleteAction.CASCADE)// deletes all child elements (orders) when parent (customer) is deleted
	private CustomerEntity customer;
	
	@Column(name="order_date")
	private String orderDate; 
	
	@Column(name="status")
	private Short status;

	public OrderEntity() {
		
	}

	public OrderEntity(Long id, CustomerEntity customer, String orderDate, Short status) {
		super();
		this.id = id;
		this.customer = customer;
		this.orderDate = orderDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
	
	

	
	
	
	

	

	
}
