package com.grownited.controller;


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

import jakarta.servlet.http.HttpSession;




@Controller
public class VendorController {
	
	
	@Autowired
	UserRepository userRepository;
	 
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/vendor")
	public String vendor() {
		return("Vendor");
	}
	
	@PostMapping("savevendor")
	public String savevendor(VendorEntity vendorEntity,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");// Object
		Integer userId = user.getUserId();
		vendorEntity.setUserId(userId);
		
		vendorRepository.save(vendorEntity);
		//session.setAttribute("vendor", vendorEntity);
		return "redirect:/listvendor";
	}

	@GetMapping("/listvendor")
	public String listvendor(Model model) {
		 
		 model.addAttribute("vendorList", vendorRepository.getAll());
		 return "ListVendor";
	}
	
	@GetMapping("/viewvendor")
	public String viewvendor(Integer vendorId, Model model ) {
		
		//List<VendorDto> vendor =  vendorRepository.getByVendorId(vendorId);
		
			model.addAttribute("vendor", vendorRepository.getByVendorId(vendorId));
			
			//session.setAttribute("vendor", vendor);
		
		return "ViewVendor";
	}
	
	@GetMapping("/deletevendor")
	public String deletevendor(Integer vendorId) {
		vendorRepository.deleteById(vendorId);
		return "redirect:/listvendor";
	}
	
	@GetMapping("editvendor")
	public String editVendor(Integer vendorId,Model model) {
		Optional<VendorEntity> op = vendorRepository.findById(vendorId);
		if (op.isEmpty()) {
			return "redirect:/listvendor";
		} else {
			model.addAttribute("vendor",op.get());
			return "EditVendor";

		}
	}
	
	@PostMapping("updatevendor")
	public String updateVehndor(VendorEntity vendorEntity) { 
		
		System.out.println(vendorEntity.getVendorId());

		Optional<VendorEntity> op = vendorRepository.findById(vendorEntity.getVendorId());
		
		if(op.isPresent())
		{
			VendorEntity dbVendor = op.get();  
			dbVendor.setVendorTitle(vendorEntity.getVendorTitle());
			vendorRepository.save(dbVendor);
		}
		return "redirect:/listvendor";
	}
}
