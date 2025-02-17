package com.grownited.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.IncomeEntity;
import com.grownited.repository.IncomeRepository;


@Controller
public class IncomeController {
	
	
	@Autowired
	private IncomeRepository incomeRepository;
	@GetMapping("/manageincome")
	public String expense() {
		return("Income");
	}
	
	@PostMapping("saveincome")
	public String saveexpense(IncomeEntity incomeEntity) {
		System.out.println(incomeEntity.getTitle());
		System.out.println(incomeEntity.getDescription());
		System.out.println(incomeEntity.getAmount());
		incomeEntity.setStatus(true);
		incomeEntity.setTransaction_date(new Date());
		incomeRepository.save(incomeEntity);
		return("Income");
	}
	
	
	

}

