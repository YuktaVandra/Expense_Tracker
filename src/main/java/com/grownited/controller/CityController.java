package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;



@Controller
public class CityController {
	
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping("newcity")
	public String city(Model model) {
     
	List<StateEntity> allState = stateRepository.findAll();// all state
		
		model.addAttribute("allState",allState);
		return("NewCity");
	}
	
	@PostMapping("savecity")
	public String savecity(CityEntity cityEntity) {
		cityRepository.save(cityEntity);
		return "redirect:/newcity";
	}
	
	@GetMapping("/listcity")
	public String listcity(Model model) {
		 List<CityEntity> cityList = cityRepository.findAll();
		 model.addAttribute("cityList", cityList);
		 return "ListCity";
	}
	
	@GetMapping("/viewcity")
	public String viewcity(Integer cityId, Model model) {
		Optional<CityEntity> op = cityRepository.findById(cityId);
		if(op.isEmpty()) {
			//Data not Found
		}else {
			CityEntity city = op.get();
			model.addAttribute("city", city);
		}
		return "ViewCity";
	}
	
	@GetMapping("/deletecity")
	public String deletecity(Integer cityId) {
		cityRepository.deleteById(cityId);
		return "redirect:/listcity";
	}

}
