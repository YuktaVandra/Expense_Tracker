package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class SessionController {
	
	@GetMapping(value = {"/","signup"})
	public String signup() {
		return("Signup");
	}
	
	@GetMapping("login")
	public String login() {
		return("Login");
	}
	
	@PostMapping("saveuser")
		public String saveuser() {
			return("Login");
		}
	
	@GetMapping("/forgetpassword")
	public String forgetpassword() {
		return("Forgetpassword");
	}
	

}
