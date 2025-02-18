package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.SubcategoryEntity;

import com.grownited.repository.SubcategoryRepository;

@Controller
public class SubcategoryController {
	
	@Autowired
    private SubcategoryRepository subcategoryRepository;
	@GetMapping("/managesubcategory")
	public String category() {
		return("Subcategory");
	}
	
	@PostMapping("savesubcategory")
	public String savecategory(SubcategoryEntity subcategoryEntity) {
		subcategoryRepository.save(subcategoryEntity);
		return "redirect:/listsubcategory";
	}
	
	@GetMapping("/listsubcategory")
	public String listsubcategory(Model model) {
		 List<SubcategoryEntity> subcategoryList = subcategoryRepository.findAll();
		 model.addAttribute("subcategoryList", subcategoryList);
		 return "ListSubcategory";
	}

}
