package com.furnitureshop.app.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furnitureshop.app.v1.entity.FavoriteEntity;
import com.furnitureshop.app.v1.service.FavoriteService;
//NOT WORKING
@RestController
@RequestMapping("/favorites")
public class FavoriteController {
	@Autowired
	public FavoriteService favoriteService;
	
	
	@GetMapping
	public List<FavoriteEntity> getAllFavorites(){
		return favoriteService.getAllFavorites();
		
	}
	
	@GetMapping("/{id}")
	public FavoriteEntity getFavoriteById(@PathVariable Long id) {
		return favoriteService.getFavoriteById(id);
	}
	
	@PostMapping FavoriteEntity createFavorite(FavoriteEntity favorite) { 
		return favoriteService.createFavorite(favorite);
	}
	
	@PutMapping("/{id}")
	public void updateFavorite(@PathVariable Long id, FavoriteEntity newFavorite) {
		favoriteService.updateFavorite(id, newFavorite);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFavorite(@PathVariable Long id) {
		favoriteService.deleteFavorite(id);
	}
	
	

	

}
