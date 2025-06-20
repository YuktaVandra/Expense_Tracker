package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.CategoryDto;
import com.grownited.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
	
	@Query(value = "select c.*,u.first_name,u.last_name,u.email from users u,category c where u.user_id = c.user_id",nativeQuery = true)
	List<CategoryDto> getAll();
	
	@Query(value = "select c.*,u.first_name,u.last_name,u.email from users u,category c where u.user_id = c.user_id and c.category_id = :categoryId",nativeQuery = true)
	List<CategoryDto> getCategoryId(Integer categoryId);
	
}
