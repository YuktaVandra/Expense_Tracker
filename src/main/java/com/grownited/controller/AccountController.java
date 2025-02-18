package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.repository.AccountRepository;




@Controller
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	@GetMapping("/manageaccount")
	public String account() {
		return("Account");
	}
	
	@PostMapping("saveaccount")
	public String saveaccount(AccountEntity accountEntity) {
		accountRepository.save(accountEntity);
		return "redirect:/listaccount";
	}
	
	@GetMapping("/listaccount")
	public String listaccount(Model model) {
		List<AccountEntity> accountList = accountRepository.findAll();
		model.addAttribute("accountList", accountList);
		return("ListAccount");
	}

}
