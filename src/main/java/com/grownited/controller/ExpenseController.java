package com.grownited.controller;

import java.util.Date;
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


@Controller
public class ExpenseController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SubcategoryRepository subcategoryRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	@GetMapping("/manageexpense")
	public String expense(Model model) {
		
		List<UserEntity> allUser = userRepository.findAll();
		model.addAttribute("allUser", allUser);
		
		List<CategoryEntity> allCategory = categoryRepository.findAll();
		model.addAttribute("allCategory", allCategory);
		
		List<SubcategoryEntity> allSubcategory = subcategoryRepository.findAll();
		model.addAttribute("allSubcategory", allSubcategory);
		
		List<AccountEntity> allAccount = accountRepository.findAll();
		model.addAttribute("allAccount", allAccount);
		
		List<VendorEntity> allVendor = vendorRepository.findAll();
		model.addAttribute("allVendor", allVendor);
		return("Expense");
	}
	
	@PostMapping("saveexpense")
	public String saveexpense(ExpenseEntity expenseEntity) {
		expenseEntity.setStatus(true);
		expenseEntity.setTransactionDate(new Date());
		expenseRepository.save(expenseEntity);
		return "redirect:/listexpense";
	}
	
	@GetMapping("/listexpense")
	public String listexpense(Model model) {
		 
		 model.addAttribute("expenseList", expenseRepository.getAll());
		 return "ListExpense";
	}
	
	@GetMapping("/viewexpense")
	public String viewexpense(Integer expenseId, Model model) {
		
			model.addAttribute("expense", expenseRepository.getExpenseId(expenseId));
		
		return "ViewExpense";
	}
	
	@GetMapping("/deleteexpense")
	public String deleteexpense(Integer expenseId) {
		expenseRepository.deleteById(expenseId);
		return "redirect:/listexpense";
	}
	

}
