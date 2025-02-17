package com.grownited.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		System.out.println(categoryEntity.getTitle());
		categoryRepository.save(categoryEntity);
		return ("Category");
	}
	
}
