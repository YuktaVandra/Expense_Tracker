package com.grownited.controller.Admin;


import java.util.List;
import java.util.Optional;

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
	@GetMapping("adminnewstate")
	public String state() {
		return("Admin/NewState");
	}
	
	@PostMapping("adminsavestate")
		public String savestate(StateEntity entityState) {
		stateRepository.save(entityState);
		return "redirect:/adminliststate";
	}
	
	@GetMapping("/adminliststate")
	public String adminliststate(Model model) {
		 List<StateEntity> stateList = stateRepository.findAll();
		 model.addAttribute("stateList", stateList);
		 return "Admin/AdminListState";
	}
	
	@GetMapping("/adminviewstate")
	public String adminviewstate(Integer stateId, Model model) {
		Optional<StateEntity> op = stateRepository.findById(stateId);
		if(op.isEmpty()) {
			//Data not Found
		}else {
			StateEntity state = op.get();
			model.addAttribute("state", state);
		}
		return "Admin/AdminViewState";
	}
	
	@GetMapping("/admindeletestate")
	public String admindeletestate(Integer stateId) {
		stateRepository.deleteById(stateId);
		return "redirect:/adminliststate";
	}
	
//	@GetMapping("editstate")
//	public String editstate(Integer stateId,Model model) {
//		Optional<StateEntity>op=stateRepository.findById(stateId);
//		if(op.isEmpty()) {
//			return"redirect:/liststate";
//		}else {
//			model.addAttribute("state", op.get());
//			return"EditState";
//		}
//	}
//	
//	@PostMapping("updatestate")
//	public String updateState(StateEntity stateEntity) {
//		Optional<StateEntity>op=stateRepository.findById(stateEntity.getStateId());
//		if(op.isPresent()) {
//			StateEntity dbstate=op.get();
//			dbstate.setStateName(stateEntity.getStateName());
//			stateRepository.save(dbstate);
//		}return"redirect:/liststate";
//	}

}
