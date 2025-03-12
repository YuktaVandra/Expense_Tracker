package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grownited.Dto.SubcategoryDto;
import com.grownited.entity.SubcategoryEntity;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Integer> {
	
	@Query(value = "SELECT s.subcategory_id, s.category_id, s.user_id, s.subcategory_title,"
			+ " u.first_name, u.created_at , c.category_title FROM  users u, category c, subcategory s WHERE s.user_id = u.user_id AND s.category_id = c.category_id ",nativeQuery = true)
	List<SubcategoryDto> getAll();
	
	@Query(value = "SELECT s.subcategory_id, s.category_id, s.user_id, s.subcategory_title,"
			+ " u.first_name, u.created_at , c.category_title FROM  users u, category c, subcategory s WHERE s.user_id = u.user_id AND s.category_id = c.category_id AND s.subcategory_id = :subcategoryId ",nativeQuery = true)
	List<SubcategoryDto> getBySubcategoryId(Integer subcategoryId);

}
