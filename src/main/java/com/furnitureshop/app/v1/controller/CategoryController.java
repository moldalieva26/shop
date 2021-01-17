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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.furnitureshop.app.v1.entity.CategoryEntity;
import com.furnitureshop.app.v1.entity.ProductCategoryEntity;
import com.furnitureshop.app.v1.service.CategoryService;


@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;
	
	@GetMapping
	public List<CategoryEntity> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public CategoryEntity getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping
	public CategoryEntity createCategory(@RequestBody CategoryEntity category) { 
		return categoryService.createCategory(category);
	}

	
	@PutMapping("/{id}")
	public CategoryEntity updateCategory(@PathVariable Long id, @RequestBody CategoryEntity newCategory) { 
		return categoryService.updateCategory(id, newCategory);
	}
	
	
	@DeleteMapping("/{id}") 
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		
	}

}
