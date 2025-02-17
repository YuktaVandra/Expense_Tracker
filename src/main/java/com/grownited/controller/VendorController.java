package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.VendorEntity;
import com.grownited.repository.VendorRepository;




@Controller
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository;
	@GetMapping("/vendor")
	public String vendor() {
		return("Vendor");
	}
	
	@PostMapping("savevendor")
	public String savevendor(VendorEntity vendorEntity) {
		System.out.println(vendorEntity.getTitle());
		vendorRepository.save(vendorEntity);
		return ("Vendor");
	}

}
