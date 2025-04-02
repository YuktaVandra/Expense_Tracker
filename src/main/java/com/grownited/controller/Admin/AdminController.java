package com.grownited.controller.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.CityRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.IncomeRepository;
import com.grownited.repository.StateRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	SubcategoryRepository subcategoryRepository;
	
	@Autowired
	IncomeRepository incomeRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@GetMapping("admindashboard")
	public String adminDashboard() {
		return "Admin/AdminDashboard";
	}



@GetMapping("/adminlistaccount")
public String adminlistaccount(Model model) {
	
	model.addAttribute("accountList", accountRepository.getAll());
	return("Admin/AdminListAccount");
}

@GetMapping("/adminlistcategory")
public String adminlistcategory(Model model) {
	
	//List<CategoryDto> categoryList = categoryRepository.getAll();
	model.addAttribute("categoryList",categoryRepository.getAll());
	return "Admin/AdminListCategory";
}

@GetMapping("/adminlistsubcategory")
public String adminlistsubcategory(Model model) {
	
	model.addAttribute("subcategoryList", subcategoryRepository.getAll());
	return("Admin/AdminListSubcategory");
}
@GetMapping("/adminlistexpense")
public String adminlistexpense(Model model) {
	
	model.addAttribute("expenseList", expenseRepository.getAll());
	return("Admin/AdminListExpense");
}
@GetMapping("/adminlistincome")
public String adminlistincome(Model model) {
	
	model.addAttribute("incomeList", incomeRepository.getAll());
	return("Admin/AdminListIncome");
}
@GetMapping("/adminlistcity")
public String adminlistcity(Model model) {
	
	model.addAttribute("cityList", cityRepository.getAll());
	return("Admin/AdminListCity");
}



@GetMapping("/adminlistuser")
public String adminlistuser(Model model) {
	
	model.addAttribute("userList", userRepository.findAll());
	return("Admin/AdminListUser");
}

@GetMapping("/adminlistvendor")
public String adminlistvendor(Model model) {
	
	model.addAttribute("vendorList", vendorRepository.getAll());
	return("Admin/AdminListVendor");
}

@GetMapping("/adminviewaccount")
public String adminviewaccount(Integer accountId, Model model) {
	
    model.addAttribute("account", accountRepository.getbyAccountId(accountId));
    
	return "Admin/AdminViewAccount";
}

@GetMapping("/admindeleteaccount")
public String admindeleteaccount(Integer accountId) {
	accountRepository.deleteById(accountId);
	return "redirect:/adminlistaccount";
}

@GetMapping("/adminviewcategory")
public String adminviewcategory(Integer categoryId, Model model,HttpSession session) {
    model.addAttribute("category", categoryRepository.getCategoryId(categoryId));
	return "Admin/AdminViewCategory";
}

@GetMapping("/admindeletecategory")
public String admindeletecategory(Integer categoryId) {
	categoryRepository.deleteById(categoryId);
	return "redirect:/adminlistcategory";
}


@GetMapping("/adminviewcity")
public String adminviewcity(Integer cityId, Model model) {
	
		model.addAttribute("city", cityRepository.getCityId(cityId));
	
	return "Admin/AdminViewCity";
}

@GetMapping("/admindeletecity")
public String admindeletecity(Integer cityId) {
	cityRepository.deleteById(cityId);
	return "redirect:/adminlistcity";
}

@GetMapping("/adminviewexpense")
public String adminviewexpense(Integer expenseId, Model model) {
	
	List<Object[]> op = expenseRepository.getExpenseId(expenseId);
		model.addAttribute("expense", op);
	
	return "Admin/AdminViewExpense";
}

@GetMapping("/admindeleteexpense")
public String admindeleteexpense(Integer expenseId) {
	expenseRepository.deleteById(expenseId);
	return "redirect:/adminlistexpense";
}

@GetMapping("/adminviewincome")
public String adminviewincome(Integer incomeId, Model model) {
	
	List<Object[]> op = incomeRepository.getByIncomeId(incomeId);
	
		model.addAttribute("income",op);
	
	return "AdminViewIncome";
}

@GetMapping("/admindeletincome")
public String admindeleteincome(Integer incomeId) {
	incomeRepository.deleteById(incomeId);
	return "redirect:/adminlistincome";
}



@GetMapping("/adminviewsubcategory")
public String adminviewsubcategory(Integer subcategoryId, Model model) {
	
	
    model.addAttribute("subcategory", subcategoryRepository.getBySubcategoryId(subcategoryId));
    	
		
	return "Admin/AdminViewSubcategory";
}

@GetMapping("/admindeletesubcategory")
public String admindeletesubcategory(Integer subcategoryId) {
	subcategoryRepository.deleteById(subcategoryId);
	return "redirect:/adminlistsubcategory";
}

@GetMapping("/adminviewuser")
public String adminviewuser(Integer userId, Model model) {
	
	System.out.println("id ===> " + userId);
	
	Optional<UserEntity> op = userRepository.findById(userId);
	
	if(op.isEmpty()) {
		//Data not found
	}else {
		UserEntity user = op.get();
		model.addAttribute("user", user);
	}
	
	return "Admin/AdminViewUser";
}

@GetMapping("/admindeleteuser")
public String admindeleteMember(Integer userId) {
	userRepository.deleteById(userId);
	return "redirect:/adminlistuser";
}

@GetMapping("/adminviewvendor")
public String adminviewvendor(Integer vendorId, Model model ) {
	
	//List<VendorDto> vendor =  vendorRepository.getByVendorId(vendorId);
	
		model.addAttribute("vendor", vendorRepository.getByVendorId(vendorId));
		
		//session.setAttribute("vendor", vendor);
	
	return "Admin/AdminViewVendor";
}

@GetMapping("/admindeletevendor")
public String admindeletevendor(Integer vendorId) {
	vendorRepository.deleteById(vendorId);
	return "redirect:/adminlistvendor";
}
}