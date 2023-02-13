package com.gopal.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable>{
	
   

}
