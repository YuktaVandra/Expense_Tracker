package com.grownited.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;

@Controller
public class SessionController {

	@Autowired
	MailService serviceMail;
	
	@Autowired
	UserRepository repositoryUser;
	
	@Autowired
	PasswordEncoder encoder;
	
    @Autowired
    private UserRepository userRepository;
	@GetMapping(value = {"/","signup"})
	public String signup() {
		return("Signup");
	}

	@GetMapping("login")
	
	public String login(UserEntity userEntity) {
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		return("Login");
	}
	
	@PostMapping("saveuser")
		
		public String saveuser(UserEntity userEntity) {
		userEntity.setCreatedAt(new Date());
		userEntity.setStatus(true);
		userEntity.setRole("USER");
		
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		
		String encPassword = encoder.encode(userEntity.getPassword());
		userEntity.setPassword(encPassword);
		
		userRepository.save(userEntity);
		
		return "Login";
		}
	
	@GetMapping("/listuser")
	public String listuser(Model model) {
		 List<UserEntity> userList = userRepository.findAll();
		 model.addAttribute("userList", userList);
		 return "ListUser";
	}
	

@GetMapping("forgetpassword")
	public String forgetpassword(){
		return("Forgetpassword");
}


@PostMapping("sendotp")
public String sendotp() {
	return("UpdatePassword");
}

@PostMapping("updatepassword")
public String updatepassword(){
	return("UpdatePassword");
}




}



