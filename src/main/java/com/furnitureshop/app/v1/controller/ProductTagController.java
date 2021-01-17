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

import com.furnitureshop.app.v1.entity.ProductTagEntity;
import com.furnitureshop.app.v1.service.ProductTagService;

// Rename vars in model class
@RestController
@RequestMapping("/producttags")
public class ProductTagController {
	@Autowired
	public ProductTagService productTagService;
	
	@GetMapping
	public List<ProductTagEntity> getAllProductTags() {
		return productTagService.getAllTags(); 
		
	}
	
	@GetMapping("/{id}")
	public ProductTagEntity getProductTag(@PathVariable Long id) { 
		return productTagService.getTagById(id);
	}
	
	@PostMapping
	public ProductTagEntity createProductTag(@RequestBody ProductTagEntity tag) { // does not work
		return productTagService.createTag(tag);
		
	}
	
	@PutMapping("/{id}")
	public ProductTagEntity updateProductTag(@PathVariable Long id, @RequestBody ProductTagEntity newTag) { // does not work
		return productTagService.updateTag(id, newTag);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteProductTag(@PathVariable Long id) {
		productTagService.deleteTag(id);
	}
	

}
