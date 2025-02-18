package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.repository.CityRepository;

@Controller
public class CityController {
	
	@Autowired
	private CityRepository cityRepository;
	@GetMapping("newcity")
	public String city() {
		return("NewCity");
	}
	
	@PostMapping("savecity")
	public String savecity(CityEntity cityEntity) {
		cityRepository.save(cityEntity);
		return "redirect:/listcity";
	}
	
	@GetMapping("/listcity")
	public String listcity(Model model) {
		 List<CityEntity> cityList = cityRepository.findAll();
		 model.addAttribute("cityList", cityList);
		 return "ListCity";
	}

}
