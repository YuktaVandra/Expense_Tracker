package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.ExpenseDto;
import com.grownited.entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> {
	
	@Query(value = "SELECT e.expense_id, e.category_id, e.subcategory_id, e.account_id, e.vendor_id, e.user_id, e.expense_title, e.expense_amount, e.description, e.status, e.transaction_date,"
			+ " u.first_name, c.category_title, s.subcategory_title , a.account_title, v.vendor_title, a.account_amount FROM expense e, users u, category c, subcategory s, account a, vendor v WHERE e.user_id = u.user_id AND e.category_id = c.category_id AND e.subcategory_id = s.subcategory_id AND e.account_id = a.account_id AND e.vendor_id = v.vendor_id",nativeQuery = true)
	List<ExpenseDto> getAll();

}
