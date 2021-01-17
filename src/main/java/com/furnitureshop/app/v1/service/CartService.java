package com.furnitureshop.app.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureshop.app.v1.entity.CartEntity;
import com.furnitureshop.app.v1.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	public CartRepository cartRepository;

	public List<CartEntity> getAllCarts() {
		return cartRepository.findAll();
	}

	public CartEntity getCartById(Long id) {
		return cartRepository.findById(id).get();
	}

	public CartEntity createCart(CartEntity cart) {
		return cartRepository.save(cart);
	}

	public void deleteCart(Long id) {
		cartRepository.deleteById(id);
	}

}
