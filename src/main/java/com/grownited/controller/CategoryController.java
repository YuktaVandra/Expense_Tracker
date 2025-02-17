package com.grownited.controller;


import java.util.List;

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
		return ("Category");
	}
	
	@GetMapping("/listcategory")
	public String listcategory(Model model) {
		List<CategoryEntity> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		return "ListCategory";
	}
	
}
