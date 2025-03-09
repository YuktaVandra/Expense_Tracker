package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VendorRepository;




@Controller
public class VendorController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/vendor")
	public String vendor(Model model) {
		List<UserEntity> allUser = userRepository.findAll();
		model.addAttribute("allUser", allUser);
		return("Vendor");
	}
	
	@PostMapping("savevendor")
	public String savevendor(VendorEntity vendorEntity) {
		vendorRepository.save(vendorEntity);
		return "redirect:/listvendor";
	}

	@GetMapping("/listvendor")
	public String listvendor(Model model) {
		 
		 model.addAttribute("vendorList", vendorRepository.getAll());
		 return "ListVendor";
	}
	
	@GetMapping("/viewvendor")
	public String viewvendor(Integer vendorId, Model model) {
		Optional<VendorEntity> op = vendorRepository.findById(vendorId);
		if(op.isEmpty()) {
			//Data not Found
		}else {
			VendorEntity vendor = op.get();
			model.addAttribute("vendor", vendor);
		}
		return "ViewVendor";
	}
	
	@GetMapping("/deletevendor")
	public String deletevendor(Integer vendorId) {
		vendorRepository.deleteById(vendorId);
		return "redirect:/listvendor";
	}
}
