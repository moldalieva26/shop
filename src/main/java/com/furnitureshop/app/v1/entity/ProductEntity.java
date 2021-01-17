package com.furnitureshop.app.v1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="product_name")
	private String productName; // changed it
	
	@Column(name="price")
	private Float price;
	
	@Column(name="category_id")
	private Long categoryId;
	
	@Column(name="description")
	private String description; 
	
	@Column(name="in_stock")
	private Boolean inStock;
	
	@Column(name="quantity_available")
	private Integer quantityAvailable;
	
	
	@OneToOne(mappedBy="productId") // comes from: ProductDetail.Class -> private Product productId;
	private ProductDetailEntity productDetail; 
	
	public ProductEntity() {
		
	}
	
	

	public ProductEntity(Long id, String productName, Float price, Long categoryId, String description, Boolean inStock,
			Integer quantityAvailable, ProductDetailEntity productDetail) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.categoryId = categoryId;
		this.description = description;
		this.inStock = inStock;
		this.quantityAvailable = quantityAvailable;
		this.productDetail = productDetail;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	public Integer getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(Integer quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public ProductDetailEntity getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetailEntity productDetail) {
		this.productDetail = productDetail;
	}

	
	

}
