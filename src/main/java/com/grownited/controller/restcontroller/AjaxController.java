package com.grownited.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.VendorRepository;

@RestController
public class AjaxController {
	
	@Autowired
	SubcategoryRepository subcategoryRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@GetMapping("/getallsubcategorybycategoryid/{categoryId}")
	public List<SubcategoryEntity> getAllSubcategoyByCategoryId(@PathVariable Integer categoryId){
		System.out.println(categoryId);
		
		List<SubcategoryEntity> allSubCategory = subcategoryRepository.findByCategoryId(categoryId);
		
		return allSubCategory ;
	}
	
	@GetMapping("/getallvendorbycategoryid/{categoryId}")
	public List<VendorEntity> getAllVendorByCategoryId(@PathVariable Integer categoryId){
		System.out.println(categoryId);
		
		List<VendorEntity> allVendor = vendorRepository.findByCategoryId(categoryId);
		
		return allVendor ;
	}

}
