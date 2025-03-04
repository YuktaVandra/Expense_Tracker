package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.AccountDto;
import com.grownited.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
	
	@Query(value = "select a.*,u.first_name from users u,account a where u.user_id = a.user_id", nativeQuery = true)
	List<AccountDto> getAll();
	

}
