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
import com.furnitureshop.app.v1.entity.TagEntity;
import com.furnitureshop.app.v1.service.TagService;


@RestController
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	public TagService tagService;
	
	@GetMapping
	public List<TagEntity> getTags() {
		return tagService.getAllTags(); 
		
	}
	
	@GetMapping("/{id}")
	public TagEntity getTag(@PathVariable Long id) { 
		return tagService.getTagById(id);
	}
	
	@PutMapping("/{id}")
	public TagEntity updateTag(@PathVariable Long id, @RequestBody TagEntity newTag) { // working incorrectly ??? returns null
		return tagService.updateTag(id, newTag);
	}
	
	@PostMapping
	public TagEntity createTag(@RequestBody TagEntity tag) {
		return tagService.createTag(tag);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteTag(@PathVariable Long id) {
		tagService.deleteTag(id);
	}
	
	
	
	
	

}
