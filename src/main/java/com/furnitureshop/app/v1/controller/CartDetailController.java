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

import com.furnitureshop.app.v1.entity.CartDetailEntity;
import com.furnitureshop.app.v1.service.CartDetailService;


@RestController
@RequestMapping("/cartdetails")
public class CartDetailController {
	@Autowired CartDetailService cartDetailService;
	
	@GetMapping("/{id}")
	public CartDetailEntity getCartById(@PathVariable Long id) {
		return cartDetailService.getCartById(id);
	}
	
	@GetMapping
	public List<CartDetailEntity> getAllCartDetails(){
		return cartDetailService.getAllCartDetails();
	}
	
	@PostMapping //org.hibernate.PropertyValueException: not-null property references a null or transient value : com.furnitureshop.app.v1.entity.CartDetail.cartId
	public CartDetailEntity createCartDetail(CartDetailEntity cartDetail) { // postman: Column 'cart_id' cannot be null. mysql works
		return cartDetailService.createCartDetail(cartDetail);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCartDetail(@PathVariable Long id) {
		cartDetailService.deleteCartDetail(id);
	}
	
	@PutMapping("/{id}")
	public void updateCartDetail(@PathVariable Long id, CartDetailEntity newCartDetail) {
		cartDetailService.updateCartDetail(id, newCartDetail);
	}
	

}
