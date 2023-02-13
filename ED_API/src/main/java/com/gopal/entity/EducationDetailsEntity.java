package com.gopal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_EDUCATION")
@Data
public class EducationDetailsEntity {
    
	@Id
	@GeneratedValue
	private Integer educationId;
	private String highestDegree;
	private String universityName;
	private Integer graduationYear;
	
	private Long caseNum;
	
	
}
