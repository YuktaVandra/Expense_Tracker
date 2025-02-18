package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		vendorRepository.save(vendorEntity);
		return "redirect:/listvendor";
	}

	@GetMapping("/listvendor")
	public String listvendor(Model model) {
		 List<VendorEntity> vendorList = vendorRepository.findAll();
		 model.addAttribute("vendorList", vendorList);
		 return "ListVendor";
	}
}
