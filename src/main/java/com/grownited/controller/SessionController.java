package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("/viewuser")
	public String viewuser(Integer userId, Model model) {
		
		System.out.println("id ===> " + userId);
		
		Optional<UserEntity> op = userRepository.findById(userId);
		
		if(op.isEmpty()) {
			//Data not found
		}else {
			UserEntity user = op.get();
			model.addAttribute("user", user);
		}
		
		return "ViewUser";
	}
	
	@GetMapping("/deleteuser")
	public String deleteMember(Integer userId) {
		userRepository.deleteById(userId);//delete from members where memberID = :memberId
		return "redirect:/listuser";
	}
	
	
	@PostMapping("/authenticate")
	public String authenticate(String email, String password,Model model) {
		System.out.println(email);
		System.out.println(password);
		
		Optional<UserEntity> op = userRepository.findByEmail(email);
		
		if(op.isPresent()) {
			UserEntity dbUser = op.get();
			if (encoder.matches(password, dbUser.getPassword())) {
				return "redirect:/home";
		}	
		}
		model.addAttribute("error","Invalid Credentials");
		return "Login";
		
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



