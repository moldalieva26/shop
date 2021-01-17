package com.furnitureshop.app.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furnitureshop.app.v1.entity.CustomerEntity;
import com.furnitureshop.app.v1.entity.ProductEntity;
import com.furnitureshop.app.v1.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired 
	ProductService productService;
	
	@GetMapping("/{id}")
	public ProductEntity getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@GetMapping()
	public List<ProductEntity> getAllProducts(){
		return productService.getAllProducts();
	} 
	
	@GetMapping("/name/{productName}") 
	public List<ProductEntity> getProductsByName(@PathVariable String productName) {
		return productService.getProductsByName(productName);
		
	}
	
	@GetMapping("/category/{categoryId}")
	public List<ProductEntity> getProductsByCategory(@PathVariable Long categoryId){
		return productService.getProductsByCategory(categoryId);
	}
	
	@PostMapping()
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity newProduct) {
		return productService.updateProduct(id, newProduct);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		 productService.deleteProduct(id);
	}
	

}
