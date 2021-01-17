package com.furnitureshop.app.v1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "tag")
public class TagEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tag_name")
	private String tagName;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_tag_id")
	// @OnDelete(action=OnDeleteAction.CASCADE)
	private List<ProductTagEntity> productTagId;

	public TagEntity() {
		
	}
	
	public TagEntity(Long id, String tagName, List<ProductTagEntity> productTagId) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.productTagId = productTagId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<ProductTagEntity> getProductTagId() {
		return productTagId;
	}

	public void setProductTagId(List<ProductTagEntity> productTagId) {
		this.productTagId = productTagId;
	}
	
	
	

}
