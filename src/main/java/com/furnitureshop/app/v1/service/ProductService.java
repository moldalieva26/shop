package com.furnitureshop.app.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureshop.app.v1.entity.CustomerEntity;
import com.furnitureshop.app.v1.entity.ProductEntity;
import com.furnitureshop.app.v1.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	public ProductEntity getProduct(Long id) {
		return productRepository.findById(id).get(); //add: if not, throw exception
	}

/*
	public Product getProductByName(String productName) {
		return productRepository.findByProductName(productName);
	}
*/
	public List<ProductEntity> getProductsByName(String productName) {
		return productRepository.findByProductName(productName);

	}

	public List<ProductEntity> getProductsByCategory(Long categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}

	public ProductEntity createProduct(ProductEntity product) {
		return productRepository.save(product);
	}

	public ProductEntity updateProduct(Long id, ProductEntity newProduct) { //update later 
		if(productRepository.findById(id).isPresent()) {
			ProductEntity existingProduct = productRepository.findById(id).get();
			existingProduct.setProductName(newProduct.getProductName());
			existingProduct.setPrice(newProduct.getPrice());
			existingProduct.setCategoryId(newProduct.getCategoryId());
			return  productRepository.save(existingProduct); //?

		} else {
			return null;
		}
		
	}

	public void deleteProduct(Long id) {
		 productRepository.deleteById(id);
	}


}
