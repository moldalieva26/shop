package com.furnitureshop.app.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furnitureshop.app.v1.entity.ProductTagEntity;

public interface ProductTagRepository extends JpaRepository<ProductTagEntity, Long> { //? needed? i do not have PK in this table

}
