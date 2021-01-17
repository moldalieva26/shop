package com.furnitureshop.app.v1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
// check setters!
@Entity
@Table(name="order_detail")
public class OrderDetailEntity { //so one order has one or multiple items
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private OrderEntity orderId;
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity productId;
	
	
	private Long quantity;
	private Float subtotal;
	private Float tax;
	// discount
	private Float total;

	public OrderDetailEntity() {
		
	}

	public OrderDetailEntity(Long id, OrderEntity orderId, ProductEntity productId, Long quantity, Float subtotal, Float tax,
			Float total) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.tax = tax;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderEntity getOrderId() {
		return orderId;
	}

	public void setOrderId(OrderEntity orderId) {
		this.orderId = orderId;
	}

	public ProductEntity getProductId() {
		return productId;
	}

	public void setProductId(ProductEntity productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	

	
	
	
}
