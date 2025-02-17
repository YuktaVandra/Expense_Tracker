package com.grownited.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		System.out.println(entityState.getStatename());
		stateRepository.save(entityState);
		return("NewState");
	}
	
	

}
