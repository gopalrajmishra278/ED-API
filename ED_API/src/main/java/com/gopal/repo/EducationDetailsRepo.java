package com.gopal.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.EducationDetailsEntity;

public interface EducationDetailsRepo extends JpaRepository<EducationDetailsEntity, Serializable> {
	
	public EducationDetailsEntity findByCaseNum(Long caseNum);

	
}
