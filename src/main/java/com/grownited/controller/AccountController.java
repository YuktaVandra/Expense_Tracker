package com.grownited.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.AccountEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.UserRepository;


import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/manageaccount")
	public String account() {
		
		return("Account");
	}
	
	@PostMapping("saveaccount")
	public String saveaccount(AccountEntity accountEntity,HttpSession session) {
		
		
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		accountEntity.setUserId(userId);
		
		accountRepository.save(accountEntity);
		
		
		return "redirect:/listaccount";
	}
	
	@GetMapping("/listaccount")
	public String listaccount(Model model) {
		
		model.addAttribute("accountList", accountRepository.getAll());
		return("ListAccount");
	}
	
	@GetMapping("/viewaccount")
	public String viewaccount(Integer accountId, Model model) {
		
	    model.addAttribute("account", accountRepository.getbyAccountId(accountId));
	    
		return "ViewAccount";
	}
	
	@GetMapping("/deleteaccount")
	public String deleteaccount(Integer accountId) {
		accountRepository.deleteById(accountId);
		return "redirect:/listaccount";
	}
	
	@GetMapping("/editaccount")
		public String editaccount(Integer accountId, Model model) {
		Optional<AccountEntity> op = accountRepository.findById(accountId);
		if(op.isEmpty()) {
			return "redirect:/listaccount";
		}else {
			AccountEntity dbAccount = op.get();
			model.addAttribute("account", dbAccount);
			
			return "EditAccount";
		}
		}
	
	@PostMapping("/updateaccount")
	public String updateaccount(AccountEntity accountEntity) {
		System.out.println(accountEntity.getAccountId()); 

		Optional<AccountEntity> op = accountRepository.findById(accountEntity.getAccountId());
		
		if(op.isPresent()) {
		
			AccountEntity dbAccount = op.get(); 
			dbAccount.setAccountAmount(accountEntity.getAccountAmount()) ;
			dbAccount.setDescription(accountEntity.getDescription());
			accountRepository.save(dbAccount);
		}
		return "redirect:/listaccount";
	}
	
		
	
	
	
	

}
