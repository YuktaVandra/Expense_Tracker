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

import jakarta.servlet.http.HttpSession;

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
	
	
	@PostMapping("authenticate")
	public String authenticate(String email, String password, Model model, HttpSession session) {// sakira@yopmail.com
																									// sakira
		System.out.println(email);
		System.out.println(password);

		// users -> email,password
		Optional<UserEntity> op = repositoryUser.findByEmail(email);
		// select * from users where email = :email and password = :password
		if (op.isPresent()) {
			// true
			// email
			UserEntity dbUser = op.get();

			boolean ans = encoder.matches(password, dbUser.getPassword());

			if (ans == true) {
				session.setAttribute("user", dbUser); // session -> user set
				if (dbUser.getRole().equals("ADMIN")) {

					return "redirect:/admindashboard";
				} else if (dbUser.getRole().equals("USER")) {

					return "redirect:/home";
				} else {
					model.addAttribute("error", "Please contact Admin with Error Code #0991");
					return "Login";
				}

			}
		}
		model.addAttribute("error", "Invalid Credentials");
		return "Login";
	}
		
		@GetMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/login";// login url
		
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



