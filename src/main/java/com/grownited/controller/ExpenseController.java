package com.grownited.controller;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grownited.Dto.AccountDto;
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
	public String expense(Model model, HttpSession session) {
		
		
		List<AccountEntity> accountList =  accountRepository.findAll();
		model.addAttribute("accountList", accountList);
		
		List<CategoryEntity> categoryList =  categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		
		List<SubcategoryEntity> subcategoryList =  subcategoryRepository.findAll();
		model.addAttribute("subcategoryList", subcategoryList);
		
		List<VendorEntity> vendorList =  vendorRepository.findAll();
		model.addAttribute("vendorList", vendorList);
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<AccountDto> userAccounts = accountRepository.getAllByUserId(user.getUserId());
		model.addAttribute("accounts", userAccounts);
		return("Expense");
	}
	
//	@PostMapping("saveexpense")
//	public String saveexpense(ExpenseEntity expenseEntity,HttpSession session) {
//		
//		UserEntity user = (UserEntity) session.getAttribute("user");
//		Integer userId = user.getUserId();
//		expenseEntity.setUserId(userId);
//	
//		expenseRepository.save(expenseEntity);
//		
//		return "redirect:/listexpense";
//	}
	
	@PostMapping("saveexpense")
	public String saveexpense(ExpenseEntity expenseEntity, HttpSession session, RedirectAttributes redirectAttributes) {
	    try {
	        UserEntity user = (UserEntity) session.getAttribute("user");
	        Integer userId = user.getUserId();
	        expenseEntity.setUserId(userId);

	        // Fetch the account
	        Integer accountId = expenseEntity.getAccountId();
	        Optional<AccountEntity> optionalAccount = accountRepository.findById(accountId);

	        if (optionalAccount.isPresent()) {
	            AccountEntity account = optionalAccount.get();

	            BigDecimal expenseAmt = expenseEntity.getExpenseAmount();
	            BigDecimal currentAmt = account.getAccountAmount();

	            // Subtract the expense
	            if (currentAmt.compareTo(expenseAmt) >= 0) {
	                BigDecimal newAmt = currentAmt.subtract(expenseAmt);
	                account.setAccountAmount(newAmt);

	                // Save updated account and expense
	                accountRepository.save(account);
	                expenseRepository.save(expenseEntity);

	                redirectAttributes.addFlashAttribute("successMessage", "Expense added and account updated!");
	            } else {
	                redirectAttributes.addFlashAttribute("errorMessage", "Not enough balance in the account!");
	            }

	        } else {
	            redirectAttributes.addFlashAttribute("errorMessage", "Account not found!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong while saving the expense.");
	    }

	    return "redirect:/listexpense";
	}

	
	@GetMapping("/listexpense")
	public String listexpense(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

	    if (user == null) {
	        return "redirect:/login";  
	    }
        
		List<Object[]> expenseList = expenseRepository.getAllByUserId(user.getUserId());
		 model.addAttribute("expenseList", expenseList);
		 return "ListExpense";
	}
	
	@GetMapping("/viewexpense")
	public String viewexpense(Integer expenseId, Model model) {
		
		List<Object[]> op = expenseRepository.getExpenseId(expenseId);
			model.addAttribute("expense", op);
		
		return "ViewExpense";
	}
	
//	@GetMapping("/deleteexpense")
//	public String deleteexpense(Integer expenseId) {
//		expenseRepository.deleteById(expenseId);
//		return "redirect:/listexpense";
//	}
	
	@GetMapping("/deleteexpense")
	public String deleteexpense(Integer expenseId, RedirectAttributes redirectAttributes) {
	    Optional<ExpenseEntity> optionalExpense = expenseRepository.findById(expenseId);

	    if (optionalExpense.isPresent()) {
	        ExpenseEntity expense = optionalExpense.get();
	        Integer accountId = expense.getAccountId();

	        Optional<AccountEntity> optionalAccount = accountRepository.findById(accountId);
	        if (optionalAccount.isPresent()) {
	            AccountEntity account = optionalAccount.get();

	            BigDecimal currentBalance = account.getAccountAmount();
	            BigDecimal expenseAmount = expense.getExpenseAmount();

	            // Add the expense amount back to the account
	            BigDecimal updatedBalance = currentBalance.add(expenseAmount);
	            account.setAccountAmount(updatedBalance);
	            accountRepository.save(account);

	            expenseRepository.deleteById(expenseId);
	            redirectAttributes.addFlashAttribute("successMessage", "Expense deleted and account balance updated.");
	        } else {
	            redirectAttributes.addFlashAttribute("errorMessage", "Associated account not found.");
	        }
	    } else {
	        redirectAttributes.addFlashAttribute("errorMessage", "Expense record not found.");
	    }

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
	
//	@PostMapping("updateexpense")
//	public String updateExpense(ExpenseEntity expenseEntity) { 
//		
//		System.out.println(expenseEntity.getExpenseId()); 
//
//		Optional<ExpenseEntity> op = expenseRepository.findById(expenseEntity.getExpenseId());
//		
//		if(op.isPresent())
//		{
//			ExpenseEntity dbExpense = op.get();  
//			dbExpense.setExpenseAmount(expenseEntity.getExpenseAmount()); 
//			dbExpense.setStatus(expenseEntity.getStatus());
//			dbExpense.setTransactionDate(expenseEntity.getTransactionDate());
//			dbExpense.setDescription(expenseEntity.getDescription());
//			expenseRepository.save(dbExpense);
//		}
//		return "redirect:/listexpense";
//	}
	
	
	@PostMapping("updateexpense")
	public String updateExpense(ExpenseEntity expenseEntity, RedirectAttributes redirectAttributes) {
	    Optional<ExpenseEntity> optionalOldExpense = expenseRepository.findById(expenseEntity.getExpenseId());

	    if (optionalOldExpense.isPresent()) {
	        ExpenseEntity oldExpense = optionalOldExpense.get();

	        // Fetch account
	        Integer accountId = oldExpense.getAccountId();
	        Optional<AccountEntity> optionalAccount = accountRepository.findById(accountId);

	        if (optionalAccount.isPresent()) {
	            AccountEntity account = optionalAccount.get();

	            BigDecimal oldAmount = oldExpense.getExpenseAmount();
	            BigDecimal newAmount = expenseEntity.getExpenseAmount();
	            BigDecimal difference = newAmount.subtract(oldAmount); // positive = increase, negative = decrease

	            BigDecimal currentBalance = account.getAccountAmount();
	            BigDecimal updatedBalance = currentBalance.subtract(difference); // account - (new - old)

	            if (updatedBalance.compareTo(BigDecimal.ZERO) >= 0) {
	                // Update account balance
	                account.setAccountAmount(updatedBalance);
	                accountRepository.save(account);

	                // Update expense details
	                oldExpense.setExpenseAmount(newAmount);
	                oldExpense.setStatus(expenseEntity.getStatus());
	                oldExpense.setTransactionDate(expenseEntity.getTransactionDate());
	                oldExpense.setDescription(expenseEntity.getDescription());

	                expenseRepository.save(oldExpense);

	                redirectAttributes.addFlashAttribute("successMessage", "Expense and account updated successfully.");
	            } else {
	                redirectAttributes.addFlashAttribute("errorMessage", "Not enough balance in account to increase expense.");
	            }
	        } else {
	            redirectAttributes.addFlashAttribute("errorMessage", "Account not found.");
	        }
	    } else {
	        redirectAttributes.addFlashAttribute("errorMessage", "Expense not found.");
	    }

	    return "redirect:/listexpense";
	}

	

}
