package com.grownited.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.IncomeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	@GetMapping("/report1")
	public String report1( Model model,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		
		BigDecimal thisMonthExpense = expenseRepository.getMonthlyExpensesByUser(month, user.getUserId());
		
		BigDecimal thisMonthIncome = incomeRepository.getMonthlyIncomeByUser(month, user.getUserId());
		
		model.addAttribute("thisMonthExpense", thisMonthExpense);
		
		model.addAttribute("thisMonthIncome", thisMonthIncome);
		
		return "Report1";
	}

}
