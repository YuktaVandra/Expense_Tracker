package com.grownited.controller;

import java.util.List;


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

@Controller
public class SubcategoryController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
    private SubcategoryRepository subcategoryRepository;
	@GetMapping("/managesubcategory")
	public String category(Model model) {
		
		List<UserEntity> allUser = userRepository.findAll();
		model.addAttribute("allUser", allUser);
		
		List<CategoryEntity> allCategory = categoryRepository.findAll();
		model.addAttribute("allCategory", allCategory);

		return("Subcategory");
	}
	
	@PostMapping("savesubcategory")
	public String savecategory(SubcategoryEntity subcategoryEntity) {
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
		return "redirect:/listaccount";
	}

}
