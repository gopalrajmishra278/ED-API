package com.gopal.repo;
import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.CitizenAppEntity;



public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Serializable> {

	//public Optional<CitizenAppEntity> findById(Integer appId);
	
	
}
