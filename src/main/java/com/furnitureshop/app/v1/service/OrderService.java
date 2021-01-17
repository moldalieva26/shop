package com.furnitureshop.app.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureshop.app.v1.entity.OrderEntity;
import com.furnitureshop.app.v1.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	public OrderRepository orderRepository;

	public List<OrderEntity> getAllOrders() {
		return orderRepository.findAll();
	}

	public OrderEntity getOrderById(Long id) {
		return orderRepository.findById(id).get();
	}

	public OrderEntity createOrder(OrderEntity order) {
		return orderRepository.save(order);
	}

	public OrderEntity updateOrder(Long id, OrderEntity newOrder) {
		if(orderRepository.findById(id).isPresent()) {
			OrderEntity order = orderRepository.findById(id).get();
			order.setCustomer(newOrder.getCustomer());
			order.setOrderDate(newOrder.getOrderDate());
			order.setStatus(newOrder.getStatus());
			// how to save
			return order;
		}
		return null; // change
	}

	public OrderEntity getOrderByCustomerCountry(String country) {
		// "SELECT o.id, o.customer_id, c.country from  customer_order o INNER JOIN on o.customer_id = c.id customer c WHERE c.country=='USA'"
		// how to integrate?
		return null;
	}
	

}
