package com.grownited.controller.Admin;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
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
	public String adminDashboard(Model model) {
		
		Integer totalUsers = userRepository.findByRole("USER").size();
		
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();

		Integer thisMonthUsersCount = userRepository.countThisMonthUsers(month); 
		
		BigDecimal totalExpenses = expenseRepository.getTotalExpenses();
		
		BigDecimal totalJanExpense = expenseRepository.getTotalJanExpense();
		
		BigDecimal totalFebExpense = expenseRepository.getTotalFebExpense();
		
		BigDecimal totalMarchExpense = expenseRepository.getTotalMarchExpense();
		
		BigDecimal thisMonthExpense = expenseRepository.getMonthlyExpenses(month);
		
		if (totalExpenses == null) totalExpenses = BigDecimal.ZERO;
	    if (thisMonthExpense == null) thisMonthExpense = BigDecimal.ZERO;

	    // Calculate percentage (avoid division by zero)
	    BigDecimal expensePercentage = BigDecimal.ZERO;
	    if (totalExpenses.compareTo(BigDecimal.ZERO) > 0) {
	        expensePercentage = thisMonthExpense
	                .multiply(BigDecimal.valueOf(100)) // Convert to percentage
	                .divide(totalExpenses, 2, RoundingMode.HALF_UP); // Keep 2 decimal places
	    }
	    
	    BigDecimal thisMonthDuePayments = expenseRepository.getMonthlyDuePayments(month);;
		
		model.addAttribute("totalUsers", totalUsers);
		model.addAttribute("thisMonthUsersCount", thisMonthUsersCount);
		model.addAttribute("thisMonthExpense", thisMonthExpense);
		model.addAttribute("expensePercentage", expensePercentage);
		model.addAttribute("thisMonthDuePayments", thisMonthDuePayments);
		model.addAttribute("totalJanExpense",totalJanExpense);
		model.addAttribute("totalFebExpense",totalFebExpense);
		model.addAttribute("totalMarchExpense",totalMarchExpense);
		return "Admin/AdminDashboard";
		
		
	}

@GetMapping("/adminlistaccount")
public String adminlistaccount(Model model) {
	
	model.addAttribute("accountList", accountRepository.getAll());
	return("Admin/AdminListAccount");
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
	
	return "Admin/AdminViewIncome";
}

@GetMapping("/admindeletincome")
public String admindeleteincome(Integer incomeId) {
	incomeRepository.deleteById(incomeId);
	return "redirect:/adminlistincome";
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


}