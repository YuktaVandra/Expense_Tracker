package com.grownited.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String expense(Model model) {
		List<AccountEntity> accountList =  accountRepository.findAll();
		model.addAttribute("accountList", accountList);
		return("Income");
	} 
	
	@PostMapping("saveincome")
	public String saveexpense(IncomeEntity incomeEntity,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		incomeEntity.setUserId(userId);
		
		
		
		incomeRepository.save(incomeEntity);
		
		
		return "redirect:/listincome";
	}
	
	@GetMapping("/listincome")
	public String listincome(Model model) {
		
		List<Object[]> incomeList = incomeRepository.getAll();

		 model.addAttribute("incomeList", incomeList);
		 return "ListIncome";
	}
	
	@GetMapping("/viewincome")
	public String viewincome(Integer incomeId, Model model) {
		
		List<Object[]> op = incomeRepository.getByIncomeId(incomeId);
		
			model.addAttribute("income",op);
		
		return "ViewIncome";
	}
	
	@GetMapping("/deletincome")
	public String deleteincome(Integer incomeId) {
		incomeRepository.deleteById(incomeId);
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

@PostMapping("/updateincome")
public String updateIncome(IncomeEntity incomeEntity) {
	System.out.println(incomeEntity.getIncomeId()); 

	Optional<IncomeEntity> op = incomeRepository.findById(incomeEntity.getIncomeId());
	
	if(op.isPresent()) {
	
		IncomeEntity dbIncome  = op.get(); 
		dbIncome.setIncomeAmount(incomeEntity.getIncomeAmount()) ;
		dbIncome.setStatus(incomeEntity.getStatus());
		dbIncome.setTransactionDate(incomeEntity.getTransactionDate());
		dbIncome.setDescription(incomeEntity.getDescription());
		incomeRepository.save(dbIncome);
	}
	return "redirect:/listincome";
}

	

}

