package com.grownited.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.IncomeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
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
	
	@GetMapping("/report2")
	public String report2(Model model, HttpSession session){
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		BigDecimal totalAccountAmount = accountRepository.getTotalAccountAmount(user.getUserId());
		
		List<Object[]> accountSummary = accountRepository.getAccountSummary(user.getUserId());

	    List<String> labels = new ArrayList<>();
	    List<BigDecimal> values = new ArrayList<>();

	    for (Object[] obj : accountSummary) {
	        labels.add((String) obj[0]);  
	        values.add((BigDecimal) obj[1]);  
	    }

	    model.addAttribute("labels", labels);
	    model.addAttribute("values", values);
        
		model.addAttribute("accountSummary", accountSummary);
		
		model.addAttribute("totalAccountAmount", totalAccountAmount);
		
		return "Report2";
	}
	
	@GetMapping("/report3")
    public String report3(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");


        List<Object[]> categoryExpenseData = expenseRepository.getCategoryWiseExpense(user.getUserId());

       
        model.addAttribute("totalCategoryExpense", categoryExpenseData);

        return "Report3"; 
    }

}
