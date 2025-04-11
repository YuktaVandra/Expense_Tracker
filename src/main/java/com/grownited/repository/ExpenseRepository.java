package com.grownited.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grownited.entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> {
	
	@Query(value = "SELECT e.expense_id, e.category_id, e.subcategory_id, e.account_id, e.vendor_id, e.user_id, e.expense_title, e.expense_amount, e.description, e.status, e.transaction_date,"
			+ " u.first_name,u.last_name, c.category_title, s.subcategory_title , a.account_title, v.vendor_title, a.account_amount FROM expense e, users u, category c, subcategory s, account a, vendor v WHERE e.user_id = u.user_id AND e.category_id = c.category_id AND e.subcategory_id = s.subcategory_id AND e.account_id = a.account_id AND e.vendor_id = v.vendor_id",nativeQuery = true)
	List<Object[]> getAll();
	
	@Query(value = "SELECT e.expense_id, e.category_id, e.subcategory_id, e.account_id, e.vendor_id, e.user_id, e.expense_title, e.expense_amount, e.description, e.status, e.transaction_date,"
			+ " u.first_name,u.last_name, c.category_title, s.subcategory_title , a.account_title, v.vendor_title, a.account_amount FROM expense e, users u, category c, subcategory s, account a, vendor v WHERE e.user_id = u.user_id AND e.category_id = c.category_id AND e.subcategory_id = s.subcategory_id AND e.account_id = a.account_id AND e.vendor_id = v.vendor_id and e.expense_id = :expenseId",nativeQuery = true)
	List<Object[]> getExpenseId(Integer expenseId);

	@Query(nativeQuery = true,value="SELECT SUM(expense_amount) FROM expense WHERE MONTH(transaction_date) = MONTH(CURRENT_DATE()) ")
	BigDecimal getMonthlyExpenses(Integer month);
	
	@Query(nativeQuery = true,value="SELECT SUM(expense_amount) FROM expense")
	BigDecimal getTotalExpenses();
	
	@Query(nativeQuery = true,value="SELECT SUM(expense_amount) FROM expense WHERE MONTH(transaction_date) = MONTH(CURRENT_DATE()) and expense.status='UNPAID'")
	BigDecimal getMonthlyDuePayments(Integer month);
	
	@Query(nativeQuery = true,value = "SELECT SUM(expense_amount) FROM expense where MONTH(transaction_date) = 1 ")
	BigDecimal getTotalJanExpense();
	
	@Query(nativeQuery = true,value = "SELECT SUM(expense_amount) FROM expense where MONTH(transaction_date) = 2 ")
	BigDecimal getTotalFebExpense();
	
	@Query(nativeQuery = true,value = "SELECT SUM(expense_amount) FROM expense where MONTH(transaction_date) = 3 ")
	BigDecimal getTotalMarchExpense();
	
	@Query(value = "SELECT e.expense_id, e.category_id, e.subcategory_id, e.account_id, e.vendor_id, e.user_id, e.expense_title, e.expense_amount, e.description, e.status, e.transaction_date,"
			+ " u.first_name,u.last_name, c.category_title, s.subcategory_title , a.account_title, v.vendor_title, a.account_amount FROM expense e, users u, category c, subcategory s, account a, vendor v WHERE e.user_id = u.user_id AND e.category_id = c.category_id AND e.subcategory_id = s.subcategory_id AND e.account_id = a.account_id AND e.vendor_id = v.vendor_id and e.user_id = :userId",nativeQuery = true)
	List<Object[]> getAllByUserId(@org.springframework.data.repository.query.Param("userId") Integer userId);
	
	@Query(nativeQuery = true,value="SELECT SUM(expense_amount) FROM expense WHERE MONTH(transaction_date) = MONTH(CURRENT_DATE()) and  expense.user_id = :userId  ")
	BigDecimal getMonthlyExpensesByUser(Integer month,@org.springframework.data.repository.query.Param("userId") Integer userId);
	
	@Query(value = """
		    SELECT c.category_title AS category, SUM(e.expense_amount) AS totalAmount 
		    FROM expense e 
		    JOIN category c ON e.category_id = c.category_id 
		    WHERE MONTH(e.transaction_date) = MONTH(CURDATE()) 
		      AND YEAR(e.transaction_date) = YEAR(CURDATE()) 
		    GROUP BY e.category_id, c.category_title 
		    ORDER BY totalAmount DESC
		    """, nativeQuery = true)
		List<Object[]> getThisMonthCategoryWiseExpense();
	
}
