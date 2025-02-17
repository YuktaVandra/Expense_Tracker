package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		System.out.println(accountEntity.getTitle());
		System.out.println(accountEntity.getAmount());
		System.out.println(accountEntity.getDescription());
		accountRepository.save(accountEntity);
		return ("Account");
	}

}
