package com.furnitureshop.app.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furnitureshop.app.v1.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

}
