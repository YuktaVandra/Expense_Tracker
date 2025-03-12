package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.VendorDto;
import com.grownited.entity.VendorEntity;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {
	
	@Query(value = "SELECT v.vendor_id,  v.user_id, v.vendor_title,"
			+ "u.first_name, u.email   FROM  vendor v, users u WHERE v.user_id = u.user_id ",nativeQuery = true)
	
	List<VendorDto> getAll();
	
	@Query(value = "SELECT v.vendor_id,  v.user_id, v.vendor_title,"
			+ "u.first_name, u.email   FROM  vendor v, users u WHERE v.user_id = u.user_id and v.vendor_id = :vendorId",nativeQuery = true)
	
	List<VendorDto> getByVendorId(Integer vendorId);

}
