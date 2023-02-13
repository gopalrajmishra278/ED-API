package com.gopal.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.IncomeDetailsEntity;

public interface IncomeDetailsRepo extends JpaRepository<IncomeDetailsEntity, Serializable>{
	
	public IncomeDetailsEntity findByCaseNum(Long caseNum);
	

}
