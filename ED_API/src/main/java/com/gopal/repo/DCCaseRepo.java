package com.gopal.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.DCCaseEntity;

public interface DCCaseRepo extends JpaRepository<DCCaseEntity, Serializable> {
	
     public DCCaseEntity findByCaseNum(Long caseNum);

}
