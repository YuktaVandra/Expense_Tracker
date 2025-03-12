package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.IncomeDto;
import com.grownited.entity.IncomeEntity;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {
	
	@Query(value = "SELECT i.income_id, i.account_id, i.user_id, i.income_title, i.income_amount, i.description, i.status, i.transaction_date,"
			+ "u.first_name,  a.account_title,  a.account_amount FROM income i, users u,  account a WHERE i.user_id = u.user_id AND  i.account_id = a.account_id ",nativeQuery = true)
	List<IncomeDto> getAll();
	
	@Query(value = "SELECT i.income_id, i.account_id, i.user_id, i.income_title, i.income_amount, i.description, i.status, i.transaction_date,"
			+ "u.first_name,  a.account_title,  a.account_amount FROM income i, users u,  account a WHERE i.user_id = u.user_id AND  i.account_id = a.account_id and i.income_id = :incomeId ",nativeQuery = true)
	List<IncomeDto> getByIncomeId(Integer incomeId);

}
