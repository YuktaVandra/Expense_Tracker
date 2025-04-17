package com.grownited.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grownited.entity.IncomeEntity;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {
	
	@Query(value = "SELECT i.income_id, i.account_id, i.user_id, i.income_title, i.income_amount, i.description, i.status, i.transaction_date,"
			+ "u.first_name,u.last_name,u.email,  a.account_title,  a.account_amount FROM income i, users u,  account a WHERE i.user_id = u.user_id AND  i.account_id = a.account_id ",nativeQuery = true)
	List<Object[]> getAll();
	
	@Query(value = "SELECT i.income_id, i.account_id, i.user_id, i.income_title, i.income_amount, i.description, i.status, i.transaction_date,"
			+ "u.first_name ,u.last_name,u.email,  a.account_title,  a.account_amount FROM income i, users u,  account a WHERE i.user_id = u.user_id AND  i.account_id = a.account_id and i.income_id = :incomeId ",nativeQuery = true)
	List<Object[]> getByIncomeId(Integer incomeId);
	
	@Query(value = "SELECT i.income_id, i.account_id, i.user_id, i.income_title, i.income_amount, i.description, i.status, i.transaction_date,"
			+ "u.first_name ,u.last_name,u.email,  a.account_title,  a.account_amount FROM income i, users u,  account a WHERE i.user_id = u.user_id AND  i.account_id = a.account_id and i.user_id = :userId ",nativeQuery = true)
	List<Object[]> getAllByUserId(@org.springframework.data.repository.query.Param("userId") Integer userId);
	
	@Query(nativeQuery = true,value="SELECT SUM(income_amount) FROM income WHERE MONTH(transaction_date) = MONTH(CURRENT_DATE()) and income.user_id = :userId ")
	BigDecimal getMonthlyIncomeByUser(Integer month,@org.springframework.data.repository.query.Param("userId") Integer userId);
	
	@Query(nativeQuery = true,value="SELECT SUM(income_amount) FROM income WHERE MONTH(transaction_date) = MONTH(CURRENT_DATE())  ")
	BigDecimal getMonthlyIncome(Integer month);
	
	@Query(nativeQuery = true,value="SELECT SUM(income_amount) FROM income where income.user_id = :userId ")
	BigDecimal getIncomeByUser(@org.springframework.data.repository.query.Param("userId") Integer userId);
	

}
