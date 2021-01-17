package com.furnitureshop.app.v1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class ReviewEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String text;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity productId;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private CustomerEntity customerId;
	
	private Short rating;
	private String published_at; //?
	
	ReviewEntity() {
		
		
		
	}// map it
	
	
}
