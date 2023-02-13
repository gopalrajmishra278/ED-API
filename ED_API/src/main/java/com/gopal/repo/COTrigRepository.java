package com.gopal.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.entity.COTrigEntity;

public interface COTrigRepository extends JpaRepository<COTrigEntity, Serializable>{

}
