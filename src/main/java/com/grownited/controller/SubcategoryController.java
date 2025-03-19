package com.grownited.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SubcategoryController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
    private SubcategoryRepository subcategoryRepository;
	
	@GetMapping("/managesubcategory")
	public String manageSubcategory(Model model) {
		List<CategoryEntity> categoryList =  categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		return("Subcategory");
	}
	
	@PostMapping("savesubcategory")
	public String saveSubcategory(SubcategoryEntity subcategoryEntity,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		subcategoryEntity.setUserId(userId);
		
		
		subcategoryRepository.save(subcategoryEntity);
		
		
		return "redirect:/listsubcategory";
	}
	
	@GetMapping("/listsubcategory")
	public String listsubcategory(Model model) {
		 
		 model.addAttribute("subcategoryList", subcategoryRepository.getAll());
		 return "ListSubcategory";
	}
	
	@GetMapping("/viewsubcategory")
	public String viewsubcategory(Integer subcategoryId, Model model) {
		
		
	    model.addAttribute("subcategory", subcategoryRepository.getBySubcategoryId(subcategoryId));
	    	
			
		return "ViewSubcategory";
	}
	
	@GetMapping("/deletesubcategory")
	public String deletesubcategory(Integer subcategoryId) {
		subcategoryRepository.deleteById(subcategoryId);
		return "redirect:/listsubcategory";
	}
	
	@GetMapping("editsubcategory")
	public String editSubCategory(Integer subcategoryId,Model model) {
		Optional<SubcategoryEntity> op = subcategoryRepository.findById(subcategoryId);
		if (op.isEmpty()) {
			return "redirect:/listsubcategory";
		} else {
			SubcategoryEntity subcategory = op.get();
	        model.addAttribute("subcategory", subcategory);
	       
			return "EditSubcategory";

		}
	}
		
		@PostMapping("updatesubcategory")
		public String updatesubcategory(SubcategoryEntity subcategoryEntity) {
			
			System.out.println(subcategoryEntity.getSubcategoryId()); 

			Optional<SubcategoryEntity> op = subcategoryRepository.findById(subcategoryEntity.getSubcategoryId());
			
			if(op.isPresent())
			{
				SubcategoryEntity dbSubcategory = op.get(); 
				
				dbSubcategory.setSubcategoryTitle(subcategoryEntity.getSubcategoryTitle()); 
				subcategoryRepository.save(dbSubcategory);
			}
			return "redirect:/listsubcategory";
		}

	
	}
