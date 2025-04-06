package com.grownited.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	Optional<UserEntity> findByEmail(String email);
	
	List<UserEntity> findByRole(String role);
	
	@Query(nativeQuery = true,value=" select count(*)  from users where month(created_at) = MONTH(CURRENT_DATE()) and role = 'USER'")
	Integer countThisMonthUsers(Integer month);
    
//	@Query(nativeQuery = true,value="SELECT  u.first_name,u.last_name,e.expense_amount FROM users u,expense e WHERE e.user_id = u.user_id and e.status = 'UNPAID'")
//	List<UserEntity> findUsersWithDuePayments();
	
	
}
