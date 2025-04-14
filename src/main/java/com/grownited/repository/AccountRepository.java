package com.grownited.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.AccountDto;
import com.grownited.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
	
	@Query(value = "select a.account_id, a.user_id, a.account_title, a.account_amount, a.description,"
			+ "u.first_name,u.last_name,u.email,u.password,u.contact_no,u.status from users u,account a where u.user_id = a.user_id", nativeQuery = true)
	List<AccountDto> getAll();
	
	@Query(value = "select a.account_id, a.user_id, a.account_title, a.account_amount, a.description,"
			+ "u.first_name,u.last_name,u.email,u.password,u.contact_no,u.status from users u,account a where u.user_id = a.user_id and a.account_id = :accountId", nativeQuery = true)
	List<AccountDto> getbyAccountId(Integer accountId);

	@Query(value = "SELECT a.account_id, a.user_id, a.account_title, a.account_amount, a.description, " +
            "u.first_name, u.last_name, u.email, u.password, u.contact_no, u.status " +
            "FROM users u, account a " +
            "WHERE u.user_id = a.user_id AND a.user_id = :userId", nativeQuery = true)
    List<AccountDto> getAllByUserId(@org.springframework.data.repository.query.Param("userId") Integer userId);

	@Query(nativeQuery = true,value="select SUM(account_amount) from account where account.user_id = :userId")
	BigDecimal getTotalAccountAmount(@org.springframework.data.repository.query.Param("userId") Integer userId);
	
	@Query(nativeQuery = true,value="SELECT a.account_title, a.account_amount FROM account a WHERE a.user_id = :userId")
	List<Object[]> getAccountSummary(@org.springframework.data.repository.query.Param("userId") Integer userId);

	

}
