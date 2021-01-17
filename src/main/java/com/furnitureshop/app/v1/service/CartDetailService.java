package com.furnitureshop.app.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureshop.app.v1.entity.CartEntity;
import com.furnitureshop.app.v1.entity.CartDetailEntity;
import com.furnitureshop.app.v1.repository.CartDetailRepository;

@Service
public class CartDetailService {
	@Autowired CartDetailRepository cartDetailRepository;

	public CartDetailEntity getCartById(Long id) {
		return cartDetailRepository.findById(id).get();
	}

	public List<CartDetailEntity> getAllCartDetails() {
		return cartDetailRepository.findAll();
	}

	public CartDetailEntity createCartDetail(CartDetailEntity cartDetail) {
		return cartDetailRepository.save(cartDetail);
	}

	public void deleteCartDetail(Long id) {
		cartDetailRepository.deleteById(id);		
	}

	public void updateCartDetail(Long id, CartDetailEntity newCartDetail) {
		if(cartDetailRepository.findById(id).isPresent()) {
			CartDetailEntity cartDetail = cartDetailRepository.findById(id).get();
			cartDetail.setQuantity(newCartDetail.getQuantity());
			cartDetail.setProductId(newCartDetail.getProductId());
		//	cartDetail.setCartId(newCartDetail.getCartId());

		}
		
	}

}
