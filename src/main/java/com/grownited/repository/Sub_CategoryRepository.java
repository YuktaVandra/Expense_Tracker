package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.Sub_CategoryEntity;

@Repository
public interface Sub_CategoryRepository extends JpaRepository<Sub_CategoryEntity, Integer> {

}
