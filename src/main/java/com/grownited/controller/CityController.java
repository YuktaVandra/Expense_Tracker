package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		System.out.println(cityEntity.getCityname());
		cityRepository.save(cityEntity);
		return ("NewCity");
	}

}
