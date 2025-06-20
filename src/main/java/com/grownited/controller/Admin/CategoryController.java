package com.grownited.controller.Admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.CategoryEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.UserRepository;


import jakarta.servlet.http.HttpSession;



@Controller
public class CategoryController {

    
	@Autowired
	UserRepository userRepository;
	@Autowired
    private CategoryRepository categoryRepository;
	
	
	@GetMapping("/adminmanagecategory")
	public String category() {
		return "Admin/Category";
	}
	
	@PostMapping("adminsavecategory")
	public String savecategory(CategoryEntity categoryEntity,HttpSession session) {	
		
		
		
		UserEntity user = (UserEntity) session.getAttribute("user");// Object
		Integer userId = user.getUserId();
		categoryEntity.setUserId(userId);
		
		categoryRepository.save(categoryEntity);
		
		//session.setAttribute("category", categoryEntity);
		
		return "redirect:/adminlistcategory";
	}
	
	@GetMapping("/adminlistcategory")
	public String listcategory(Model model) {
		
		//List<CategoryDto> categoryList = categoryRepository.getAll();
		model.addAttribute("categoryList",categoryRepository.getAll());
		return "Admin/AdminListCategory";
	}
	
	@GetMapping("/adminviewcategory")
	public String viewcategory(Integer categoryId, Model model,HttpSession session) {
		
		
	    model.addAttribute("category", categoryRepository.getCategoryId(categoryId));
	   
		
		return "Admin/AdminViewCategory";
	}
	
	@GetMapping("/admindeletecategory")
	public String deletecategory(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
		return "redirect:/adminlistcategory";
	}
	
//	@GetMapping("editcategory")
//	public String editCategory(Integer categoryId,Model model) {
//		Optional<CategoryEntity> op = categoryRepository.findById(categoryId);
//		if (op.isEmpty()) {
//			return "redirect:/listcategory";
//		} else {
//			CategoryEntity category = op.get();
//	        model.addAttribute("category", category);
//	       
//			return "EditCategory";
//
//		}
//	}
//		
//		@PostMapping("updatecategory")
//		public String updatecategory(CategoryEntity categoryEntity) {
//			
//			System.out.println(categoryEntity.getCategoryId()); 
//
//			Optional<CategoryEntity> op = categoryRepository.findById(categoryEntity.getCategoryId());
//			
//			if(op.isPresent())
//			{
//				CategoryEntity dbCategory = op.get(); 
//				
//				dbCategory.setCategoryTitle(categoryEntity.getCategoryTitle()); 
//				categoryRepository.save(dbCategory);
//			}
//			return "redirect:/listcategory";
//		}
//	
//	
}
