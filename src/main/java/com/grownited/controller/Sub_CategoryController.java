package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.Sub_CategoryEntity;
import com.grownited.repository.Sub_CategoryRepository;

@Controller
public class Sub_CategoryController {
	
	@Autowired
    private Sub_CategoryRepository sub_CategoryRepository;
	@GetMapping("/managesubcategory")
	public String category() {
		return("Sub_Category");
	}
	
	@PostMapping("savesubcategory")
	public String savecategory(Sub_CategoryEntity sub_CategoryEntity) {
		System.out.println(sub_CategoryEntity.getTitle());
		sub_CategoryRepository.save(sub_CategoryEntity);
		return ("Sub_Category");
	}

}
