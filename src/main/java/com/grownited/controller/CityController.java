package com.grownited.controller;

import java.util.List;

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
	
	@GetMapping("adminnewcity")
	public String city(Model model) {
     
	List<StateEntity> allState = stateRepository.findAll();// all state
		
		model.addAttribute("allState",allState);
		return("Admin/NewCity");
	}
	
	@PostMapping("adminsavecity")
	public String savecity(CityEntity cityEntity) {
		cityRepository.save(cityEntity);
		return "redirect:/adminlistcity";
	}
	
	@GetMapping("/adminlistcity")
	public String listcity(Model model) {
		 model.addAttribute("cityList", cityRepository.getAll());
		 return "Admin/AdminListCity";
	}
	
	@GetMapping("/adminviewcity")
	public String viewcity(Integer cityId, Model model) {
		
			model.addAttribute("city", cityRepository.getCityId(cityId));
		
		return "Admin/AdminViewCity";
	}
	
	@GetMapping("/admindeletecity")
	public String deletecity(Integer cityId) {
		cityRepository.deleteById(cityId);
		return "redirect:/adminlistcity";
	}
	
//	@GetMapping("editcity")
//	public String editcity(Integer cityId,Model model) {
//		Optional<CityEntity>op=cityRepository.findById(cityId);
//		if(op.isEmpty()) {
//			return"redirect:/listcity";
//		}else {
//			model.addAttribute("city", op.get());
//			return"EditCity";
//		}
//	}
//	
//	@PostMapping("updatecity")
//	public String updatecity(CityEntity city) {
//		Optional<CityEntity>op=cityRepository.findById(city.getCityId());
//		if(op.isPresent()) {
//			CityEntity dbcity=op.get();
//			dbcity.setCityName(city.getCityName());
//			cityRepository.save(dbcity);
//		}return"redirect:/listcity";
//	}

}
