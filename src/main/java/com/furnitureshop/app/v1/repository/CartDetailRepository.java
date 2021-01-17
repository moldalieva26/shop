package com.furnitureshop.app.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furnitureshop.app.v1.entity.CartDetailEntity;

public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Long> {

}
