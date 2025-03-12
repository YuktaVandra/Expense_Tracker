package com.grownited;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
		
	}
	
	@Bean
	PasswordEncoder encoder() {
	return new BCryptPasswordEncoder(5);
	}
	
	@Bean
	Cloudinary cloudinary() {
		Map<String, String> config = ObjectUtils.asMap("cloud_name", "dsujildyv", "api_key", "147359347566116",
				"api_secret", "ZbNZVkuVEDjU8jRUuyAyS5wObJQ");
		return new Cloudinary(config);
	}

}

