package com.gopal.repo;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.KidDetailsEntity;

public interface KidDetailsRepo extends JpaRepository<KidDetailsEntity, Serializable>{
	
	public List<KidDetailsEntity> findByCaseNum(Long caseNum);

}
