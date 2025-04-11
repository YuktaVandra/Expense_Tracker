package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.CityDto;
import com.grownited.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
	
	@Query(value = "select c.*,s.state_name from state s,city c where s.state_id = c.state_id",nativeQuery = true)
	 List<CityDto> getAll();
	
	@Query(value = "select c.*,s.state_name from state s,city c where s.state_id = c.state_id and c.city_id = :cityId",nativeQuery = true)
	 List<CityDto> getCityId(Integer cityId);
	 
	List<CityEntity> findByStateId(Integer stateId);
}
