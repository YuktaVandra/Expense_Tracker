package com.grownited.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ExpenseEntity;
import com.grownited.repository.ExpenseRepository;


@Controller
public class ExpenseController {
	
	
	@Autowired
	private ExpenseRepository expenseRepository;
	@GetMapping("/manageexpense")
	public String expense() {
		return("Expense");
	}
	
	@PostMapping("saveexpense")
	public String saveexpense(ExpenseEntity expenseEntity) {
		expenseEntity.setStatus(true);
		expenseEntity.setTransactionDate(new Date());
		expenseRepository.save(expenseEntity);
		return("Expense");
	}
	
	@GetMapping("/listexpense")
	public String listexpense(Model model) {
		 List<ExpenseEntity> expenseList = expenseRepository.findAll();
		 model.addAttribute("expenseList", expenseList);
		 return "ListExpense";
	}
	

}
