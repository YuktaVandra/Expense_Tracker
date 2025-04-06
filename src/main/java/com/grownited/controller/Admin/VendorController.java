package com.grownited.controller.Admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;




@Controller
public class VendorController {
	
	
	@Autowired
	UserRepository userRepository;
	 
	@Autowired
    VendorRepository vendorRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/adminvendor")
	public String vendor(Model model) {
		List<CategoryEntity> categoryList =  categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		return("Admin/Vendor");
	}
	
	@PostMapping("/adminsavevendor")
	public String adminsavevendor( VendorEntity vendorEntity,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");// Object
		Integer userId = user.getUserId();
		vendorEntity.setUserId(userId);
		
		vendorRepository.save(vendorEntity);
		//session.setAttribute("vendor", vendorEntity);
		return "redirect:/adminlistvendor";
	}

	@GetMapping("/adminlistvendor")
	public String adminlistvendor(Model model) {
		List<Object[]> vendorList = vendorRepository.getAll();
		 model.addAttribute("vendorList", vendorList);
		 return "Admin/AdminListVendor";
	}
	
	@GetMapping("/adminviewvendor")
	public String viewvendor(Integer vendorId, Model model ) {
		
		List<Object[]> vendor =  vendorRepository.getByVendorId(vendorId);
		
			model.addAttribute("vendor", vendor);
			
			//session.setAttribute("vendor", vendor);
		
		return "Admin/AdminViewVendor";
	}
	
	@GetMapping("/admindeletevendor")
	public String deletevendor(Integer vendorId) {
		vendorRepository.deleteById(vendorId);
		return "redirect:/adminlistvendor";
	}
	
//	@GetMapping("editvendor")
//	public String editVendor(Integer vendorId,Model model) {
//		Optional<VendorEntity> op = vendorRepository.findById(vendorId);
//		if (op.isEmpty()) {
//			return "redirect:/listvendor";
//		} else {
//			model.addAttribute("vendor",op.get());
//			return "EditVendor";
//
//		}
//	}
//	
//	@PostMapping("updatevendor")
//	public String updateVehndor(VendorEntity vendorEntity) { 
//		
//		System.out.println(vendorEntity.getVendorId());
//
//		Optional<VendorEntity> op = vendorRepository.findById(vendorEntity.getVendorId());
//		
//		if(op.isPresent())
//		{
//			VendorEntity dbVendor = op.get();  
//			dbVendor.setVendorTitle(vendorEntity.getVendorTitle());
//			vendorRepository.save(dbVendor);
//		}
//		return "redirect:/listvendor";
//	}
}
