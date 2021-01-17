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
import org.springframework.web.bind.annotation.RestController;

import com.furnitureshop.app.v1.entity.ProductCategoryEntity;
import com.furnitureshop.app.v1.service.ProductCategoryService;

@RestController
@RequestMapping("productcategories")
public class ProductCategoryController {
	@Autowired ProductCategoryService productCategoryService;

	@GetMapping
	public List<ProductCategoryEntity> getAllProductCategories() {
		return productCategoryService.getAllProductCategories();
	}
	
	@GetMapping("/{id}")
	public ProductCategoryEntity getProductCategory(@PathVariable Long id) {
		return productCategoryService.getProductCategory(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductCategory(@PathVariable Long id) {
		productCategoryService.deleteProductCategory(id);
	}
	
	@PostMapping()
	public ProductCategoryEntity createProductCategory(@RequestBody ProductCategoryEntity productCategory) {
			return productCategoryService.createProductCategory(productCategory);
		}
	
	@PutMapping("/{id}")
	public ProductCategoryEntity updateProductCategory(@RequestBody ProductCategoryEntity newProductCategory, Long id) {
		return null; // finish!
		
	}
	
	
	
}
