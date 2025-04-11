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
	
	@Query(nativeQuery = true, value="select u.user_id,u.first_name,u.last_name,u.email,u.contact_no,u.created_at,u.otp,u.password,u.role,u.status,u.profile_pic_path,u.city_id,u.state_id,"
			+ "c.city_name,s.state_name from users u, city c, state s where u.city_id = c.city_id and u.state_id = s.state_id")
	List<Object[]> getAll();
	
	@Query(nativeQuery = true, value="select u.user_id,u.first_name,u.last_name,u.email,u.contact_no,u.created_at,u.otp,u.password,u.role,u.status,u.profile_pic_path,u.city_id,u.state_id,"
			+ "c.city_name,s.state_name from users u, city c, state s where u.city_id = c.city_id and u.state_id = s.state_id and u.user_id = :userId")
	List<Object[]> getUserId(Integer userId);
	
	@Query(nativeQuery = true,value=" select u.*,c.city_name,s.state_name  from users u,city c,state s where month(created_at) = MONTH(CURRENT_DATE()) and role = 'USER' and u.city_id = c.city_id and u.state_id = s.state_id ")
	List<Object[]> getcountThisMonthUsersReport(Integer month);
}
