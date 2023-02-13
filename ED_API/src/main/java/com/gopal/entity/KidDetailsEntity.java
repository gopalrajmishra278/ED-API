package com.gopal.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DC_KIDS")
@Data
public class KidDetailsEntity {

    @Id
    @GeneratedValue
    private Integer kidId;
    private String kidName;
    private LocalDate kidDob;
	private Integer kidAge;
	private Long kidSsn;
	private String kidGender;
	private Long caseNum;
	
	
	
	
}
