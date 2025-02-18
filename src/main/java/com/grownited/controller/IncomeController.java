package com.grownited.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		incomeEntity.setStatus(true);
		incomeEntity.setTransactionDate(new Date());
		incomeRepository.save(incomeEntity);
		return "redirect:/listincome";
	}
	
	@GetMapping("/listincome")
	public String listincome(Model model) {
		 List<IncomeEntity> incomeList = incomeRepository.findAll();
		 model.addAttribute("incomeList", incomeList);
		 return "ListIncome";
	}
	

}

