package com.grownited.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;


@Controller
public class StateController {
	
	@Autowired
	private StateRepository stateRepository;
	@GetMapping("newstate")
	public String state() {
		return("NewState");
	}
	
	@PostMapping("savestate")
		public String savestate(StateEntity entityState) {
		stateRepository.save(entityState);
		return "redirect:/liststate";
	}
	
	@GetMapping("/liststate")
	public String liststate(Model model) {
		 List<StateEntity> stateList = stateRepository.findAll();
		 model.addAttribute("stateList", stateList);
		 return "ListState";
	}

}
