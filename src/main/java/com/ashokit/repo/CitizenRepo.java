package com.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.ashokit.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen,Integer>,QueryByExampleExecutor<Citizen> {
	
	
	@Query("select distinct(PLAN_NAME) from Citizen")
	public List<String> getplannames();
	
	@Query("select distinct(PLAN_STATUS) from Citizen ")
	public List<String> getplanstatus();
	

}
