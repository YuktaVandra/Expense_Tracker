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
import com.grownited.entity.IncomeEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.IncomeRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class IncomeController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private IncomeRepository incomeRepository;
	@GetMapping("/manageincome")
	public String expense(Model model,HttpSession session) {
		List<AccountEntity> accountList =  accountRepository.findAll();
		model.addAttribute("accountList", accountList);
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<AccountDto> userAccounts = accountRepository.getAllByUserId(user.getUserId());
		model.addAttribute("accounts", userAccounts);
		return("Income");
	} 
	
//	@PostMapping("saveincome")
//	public String saveexpense(IncomeEntity incomeEntity,HttpSession session) {
//		
//		UserEntity user = (UserEntity) session.getAttribute("user");
//		Integer userId = user.getUserId();
//		incomeEntity.setUserId(userId);
//		
//		
//		
//		incomeRepository.save(incomeEntity);
//		
//		
//		return "redirect:/listincome";
//	}
	
	@PostMapping("/saveincome")
	public String saveIncome(IncomeEntity incomeEntity, HttpSession session, RedirectAttributes redirectAttributes) {
	    try {
	        UserEntity user = (UserEntity) session.getAttribute("user");
	        Integer userId = user.getUserId();
	        incomeEntity.setUserId(userId);

	        // Fetch the account
	        Integer accountId = incomeEntity.getAccountId();
	        Optional<AccountEntity> optionalAccount = accountRepository.findById(accountId);

	        if (optionalAccount.isPresent()) {
	            AccountEntity account = optionalAccount.get();

	            BigDecimal incomeAmt = incomeEntity.getIncomeAmount();
	            BigDecimal currentAmt = account.getAccountAmount();

	            // Add income amount to current balance
	            BigDecimal newAmt = currentAmt.add(incomeAmt);
	            account.setAccountAmount(newAmt);

	            // Save both income and updated account
	            accountRepository.save(account);
	            incomeRepository.save(incomeEntity);

	            redirectAttributes.addFlashAttribute("successMessage", "Income added and account updated!");
	        } else {
	            redirectAttributes.addFlashAttribute("errorMessage", "Account not found!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong while saving the income.");
	    }

	    return "redirect:/listincome";
	}

	
	@GetMapping("/listincome")
		public String listexpense(Model model, HttpSession session) {
			UserEntity user = (UserEntity) session.getAttribute("user");

		    if (user == null) {
		        return "redirect:/login";  
		    }
	        
		
		List<Object[]> incomeList = incomeRepository.getAllByUserId(user.getUserId());

		 model.addAttribute("incomeList", incomeList);
		 return "ListIncome";
	}
	
	@GetMapping("/viewincome")
	public String viewincome(Integer incomeId, Model model) {
		
		List<Object[]> op = incomeRepository.getByIncomeId(incomeId);
		
			model.addAttribute("income",op);
		
		return "ViewIncome";
	}
	
//	@GetMapping("/deleteincome")
//	public String deleteincome(Integer incomeId) {
//		incomeRepository.deleteById(incomeId);
//		return "redirect:/listincome";
//	}
	
	@GetMapping("/deleteincome")
	public String deleteincome(Integer incomeId, RedirectAttributes redirectAttributes) {
	    Optional<IncomeEntity> optionalIncome = incomeRepository.findById(incomeId);

	    if (optionalIncome.isPresent()) {
	        IncomeEntity income = optionalIncome.get();
	        Integer accountId = income.getAccountId();

	        Optional<AccountEntity> optionalAccount = accountRepository.findById(accountId);
	        if (optionalAccount.isPresent()) {
	            AccountEntity account = optionalAccount.get();

	            BigDecimal currentBalance = account.getAccountAmount();
	            BigDecimal incomeAmount = income.getIncomeAmount();

	            // Ensure subtracting income won't make balance negative
	            if (currentBalance.compareTo(incomeAmount) >= 0) {
	                BigDecimal updatedBalance = currentBalance.subtract(incomeAmount);
	                account.setAccountAmount(updatedBalance);
	                accountRepository.save(account);

	                incomeRepository.deleteById(incomeId);
	                redirectAttributes.addFlashAttribute("successMessage", "Income deleted and account balance updated.");
	            } else {
	                redirectAttributes.addFlashAttribute("errorMessage", "Action blocked: This income cannot be deleted as it would make the account balance insufficient.");
	            }

	        } else {
	            redirectAttributes.addFlashAttribute("errorMessage", "Associated account not found.");
	        }
	    } else {
	        redirectAttributes.addFlashAttribute("errorMessage", "Income record not found.");
	    }

	    return "redirect:/listincome";
	}


	
	@GetMapping("/editincome")
	public String editIncome(Integer incomeId, Model model) {
	Optional<IncomeEntity> op = incomeRepository.findById(incomeId);
	if(op.isEmpty()) {
		return "redirect:/listincome";
	}else {
		IncomeEntity dbIncome = op.get();
		model.addAttribute("income", dbIncome);
		
		return "EditIncome";
	}
	}

//@PostMapping("/updateincome")
//public String updateIncome(IncomeEntity incomeEntity) {
//	System.out.println(incomeEntity.getIncomeId()); 
//
//	Optional<IncomeEntity> op = incomeRepository.findById(incomeEntity.getIncomeId());
//	
//	if(op.isPresent()) {
//	
//		IncomeEntity dbIncome  = op.get(); 
//		dbIncome.setIncomeAmount(incomeEntity.getIncomeAmount()) ;
//		dbIncome.setStatus(incomeEntity.getStatus());
//		dbIncome.setTransactionDate(incomeEntity.getTransactionDate());
//		dbIncome.setDescription(incomeEntity.getDescription());
//		incomeRepository.save(dbIncome);
//	}
//	return "redirect:/listincome";
//}
	
	@PostMapping("/updateincome")
	public String updateIncome(IncomeEntity incomeEntity, RedirectAttributes redirectAttributes) {
	    Optional<IncomeEntity> optionalOldIncome = incomeRepository.findById(incomeEntity.getIncomeId());

	    if (optionalOldIncome.isPresent()) {
	        IncomeEntity oldIncome = optionalOldIncome.get();

	        // Fetch associated account
	        Integer accountId = oldIncome.getAccountId();
	        Optional<AccountEntity> optionalAccount = accountRepository.findById(accountId);

	        if (optionalAccount.isPresent()) {
	            AccountEntity account = optionalAccount.get();

	            BigDecimal oldAmount = oldIncome.getIncomeAmount();
	            BigDecimal newAmount = incomeEntity.getIncomeAmount();
	            BigDecimal difference = newAmount.subtract(oldAmount); // +ve = increase, -ve = decrease

	            BigDecimal currentBalance = account.getAccountAmount();
	            BigDecimal updatedBalance = currentBalance.add(difference);

	            if (updatedBalance.compareTo(BigDecimal.ZERO) >= 0) {
	                // Update account balance
	                account.setAccountAmount(updatedBalance);
	                accountRepository.save(account);

	                // Update income details
	                oldIncome.setIncomeAmount(newAmount);
	                oldIncome.setStatus(incomeEntity.getStatus());
	                oldIncome.setTransactionDate(incomeEntity.getTransactionDate());
	                oldIncome.setDescription(incomeEntity.getDescription());

	                incomeRepository.save(oldIncome);

	                redirectAttributes.addFlashAttribute("successMessage", "Income and account updated successfully.");
	            } else {
	                redirectAttributes.addFlashAttribute("errorMessage", "Action blocked: This income cannot be deleted as it would make the account balance insufficient.");
	            }

	        } else {
	            redirectAttributes.addFlashAttribute("errorMessage", "Account not found.");
	        }

	    } else {
	        redirectAttributes.addFlashAttribute("errorMessage", "Income not found.");
	    }

	    return "redirect:/listincome";
	}


	

}

