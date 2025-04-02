package com.grownited.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
    UserRepository userRepository;
    
    @Autowired
    Cloudinary cloudinary;
    
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
		
		public String saveuser(UserEntity userEntity, MultipartFile profilePic, Model model) {
		userEntity.setCreatedAt(new Date());
		userEntity.setStatus("ACTIVE");
		userEntity.setRole("USER");
		
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		
		String encPassword = encoder.encode(userEntity.getPassword());
		userEntity.setPassword(encPassword);
		
		if(profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".png") || profilePic.getOriginalFilename().endsWith(".jpeg")  ) {
			
			try {
				Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
				
				userEntity.setProfilePicPath(result.get("url").toString());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}else {
			//
			model.addAttribute("error", "Invalid file format! Please upload a JPG, JPEG, or PNG file");
			return "Signup";
		}
		
		
		
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
		userRepository.deleteById(userId);
		return "redirect:/listuser";
	}
	
	
	@PostMapping("authenticate")
	public String authenticate(String email, String password, Model model, HttpSession session) {
																									
		System.out.println(email);
		System.out.println(password);

		
		Optional<UserEntity> op = repositoryUser.findByEmail(email);
		
		if (op.isPresent()) {
			
			UserEntity dbUser = op.get();

			boolean ans = encoder.matches(password, dbUser.getPassword());

			if (ans == true) {
				session.setAttribute("user", dbUser); 
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
			return "redirect:/login";
		
	}
	
	
	

@GetMapping("forgetpassword")
	public String forgetpassword(){
		return("Forgetpassword");
}


@PostMapping("sendotp")
public String sendotp(String email,Model model) {
	Optional<UserEntity> op = repositoryUser.findByEmail(email);
	if (op.isEmpty()) {
		// email invalid
		model.addAttribute("error", "Email not found");
		return "ForgetPassword";
	} else {
		
		String otp = "";
		otp = (int) (Math.random() * 1000000) + "";// 0.25875621458541

		UserEntity user = op.get();
		user.setOtp(otp);
		repositoryUser.save(user);// update otp for user
		serviceMail.sendOtpForForgetPassword(email, user.getFirstName(), otp);
		return "ChangePassword";

	}
}

@PostMapping("updatepassword")
public String updatepassword(String email, String password, String otp, Model model){
	Optional<UserEntity> op = repositoryUser.findByEmail(email);
	if (op.isEmpty()) {
		model.addAttribute("error", "Invalid Data");
		return "ChangePassword";
	} else {
		UserEntity user = op.get();
		if (user.getOtp().equals(otp)) {
			String encPwd = encoder.encode(password);
			user.setPassword(encPwd);
			user.setOtp("");
			repositoryUser.save(user);// update
		} else {

			model.addAttribute("error", "Invalid Data");
			return "ChangePassword";
		}
	}
	model.addAttribute("msg","Password updated");
	return "Login";
}

@GetMapping("/edituser")
public String editUser(Integer userId, Model model) {
Optional<UserEntity> op = userRepository.findById(userId);
if(op.isEmpty()) {
	return "redirect:/listuser";
}else {
	UserEntity dbUser = op.get();
	model.addAttribute("user", dbUser);
	
	return "EditUsers";
}
}

@PostMapping("/updateuser")
public String updateUser(UserEntity userEntity) {
System.out.println(userEntity.getUserId()); 

Optional<UserEntity> op = userRepository.findById(userEntity.getUserId());

if(op.isPresent()) {

	UserEntity dbUser = op.get(); 
	dbUser.setFirstName(userEntity.getFirstName());
	dbUser.setLastName(userEntity.getLastName());
	dbUser.setContactNo(userEntity.getContactNo());
	dbUser.setProfilePicPath(userEntity.getProfilePicPath());
	userRepository.save(dbUser);
}
return "redirect:/listuser";
}


}



