package com.grownited.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ExpenseEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class ExpenseController {
	
	
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubcategoryRepository subcategoryRepository;
	@Autowired
	VendorRepository vendorRepository;
	@Autowired
	ExpenseRepository expenseRepository;
	
	@GetMapping("/manageexpense")
	public String expense(Model model) {
		
		
		List<AccountEntity> accountList =  accountRepository.findAll();
		model.addAttribute("accountList", accountList);
		
		List<CategoryEntity> categoryList =  categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		
		List<SubcategoryEntity> subcategoryList =  subcategoryRepository.findAll();
		model.addAttribute("subcategoryList", subcategoryList);
		
		List<VendorEntity> vendorList =  vendorRepository.findAll();
		model.addAttribute("vendorList", vendorList);
		
		return("Expense");
	}
	
	@PostMapping("saveexpense")
	public String saveexpense(ExpenseEntity expenseEntity,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		expenseEntity.setUserId(userId);
	
		expenseRepository.save(expenseEntity);
		
		return "redirect:/listexpense";
	}
	
	@GetMapping("/listexpense")
	public String listexpense(Model model) {
		List<Object[]> expenseList = expenseRepository.getAll();
		 model.addAttribute("expenseList", expenseList);
		 return "ListExpense";
	}
	
	@GetMapping("/viewexpense")
	public String viewexpense(Integer expenseId, Model model) {
		
		List<Object[]> op = expenseRepository.getExpenseId(expenseId);
			model.addAttribute("expense", op);
		
		return "ViewExpense";
	}
	
	@GetMapping("/deleteexpense")
	public String deleteexpense(Integer expenseId) {
		expenseRepository.deleteById(expenseId);
		return "redirect:/listexpense";
	}
	
	@GetMapping("editexpense")
	public String editExpense(Integer expenseId,Model model) {
		Optional<ExpenseEntity> op = expenseRepository.findById(expenseId);
		if (op.isEmpty()) {
			return "redirect:/listexpense";
		} else {
			model.addAttribute("expense",op.get());
			return "EditExpense";

		}
	}
	
	@PostMapping("updateexpense")
	public String updateExpense(ExpenseEntity expenseEntity) { 
		
		System.out.println(expenseEntity.getExpenseId()); 

		Optional<ExpenseEntity> op = expenseRepository.findById(expenseEntity.getExpenseId());
		
		if(op.isPresent())
		{
			ExpenseEntity dbExpense = op.get();  
			dbExpense.setExpenseAmount(expenseEntity.getExpenseAmount()); 
			dbExpense.setStatus(expenseEntity.getStatus());
			dbExpense.setTransactionDate(expenseEntity.getTransactionDate());
			dbExpense.setDescription(expenseEntity.getDescription());
			expenseRepository.save(dbExpense);
		}
		return "redirect:/listexpense";
	}
	
	

}
