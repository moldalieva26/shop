package com.furnitureshop.app.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furnitureshop.app.v1.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	//    List<Book> findByNameAndPrice(String name, BigDecimal price);

}
