package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.VendorEntity;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {
	
	@Query(value = "SELECT v.vendor_id,  v.user_id, v.vendor_title,v.category_id,"
			+ "u.first_name,u.last_name, u.email,c.category_title   FROM  vendor v, users u,category c WHERE v.user_id = u.user_id and v.category_id = c.category_id ",nativeQuery = true)
	
	List<Object[]> getAll();
	
	@Query(value = "SELECT v.vendor_id,  v.user_id, v.vendor_title,v.category_id,"
			+ "u.first_name,u.last_name, u.email,c.category_title    FROM  vendor v, users u,category c  WHERE v.user_id = u.user_id and  v.category_id = c.category_id and v.vendor_id = :vendorId",nativeQuery = true)
	
	List<Object[]> getByVendorId(Integer vendorId);
	
	List<VendorEntity> findByCategoryId(Integer categoryId);

}
