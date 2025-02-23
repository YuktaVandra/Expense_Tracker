package com.grownited.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.repository.CategoryRepository;



@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
	@GetMapping("/managecategory")
	public String category() {
		return("Category");
	}
	
	@PostMapping("savecategory")
	public String savecategory(CategoryEntity categoryEntity) {
		categoryRepository.save(categoryEntity);
		return "redirect:/listcategory";
	}
	
	@GetMapping("/listcategory")
	public String listcategory(Model model) {
		List<CategoryEntity> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		return "ListCategory";
	}
	
	@GetMapping("/viewcategory")
	public String viewcategory(Integer categoryId, Model model) {
		Optional<CategoryEntity> op = categoryRepository.findById(categoryId);
		if(op.isEmpty()) {
			//Data not Found
		}else {
			CategoryEntity category = op.get();
			model.addAttribute("category", category);
		}
		return "ViewCategory";
	}
	
	@GetMapping("/deletecategory")
	public String deletecategory(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
		return "redirect:/listcategory";
	}
	
}
