package com.furnitureshop.app.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furnitureshop.app.v1.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>{

}
