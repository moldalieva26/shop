package com.furnitureshop.app.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furnitureshop.app.v1.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	List<ProductEntity> findByProductName(String productName);

	List<ProductEntity> findByCategoryId(Long categoryId);

}
