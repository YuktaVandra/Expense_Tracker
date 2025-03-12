package com.grownited.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.AccountEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.UserRepository;

@Controller
public class AccountController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepository;
	@GetMapping("/manageaccount")
	public String account(Model model) {
		
		List<UserEntity> allUser = userRepository.findAll();// all state

		model.addAttribute("allUser", allUser);
		
		return("Account");
	}
	
	@PostMapping("saveaccount")
	public String saveaccount(AccountEntity accountEntity) {
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

}
