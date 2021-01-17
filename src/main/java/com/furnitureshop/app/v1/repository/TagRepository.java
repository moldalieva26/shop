package com.furnitureshop.app.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furnitureshop.app.v1.entity.ProductTagEntity;
import com.furnitureshop.app.v1.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
