package com.grownited.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		System.out.println(expenseEntity.getTitle());
		System.out.println(expenseEntity.getDescription());
		System.out.println(expenseEntity.getAmount());
		expenseEntity.setStatus(true);
		expenseEntity.setTransaction_date(new Date());
		expenseRepository.save(expenseEntity);
		return("Expense");
	}
	
	
	

}
