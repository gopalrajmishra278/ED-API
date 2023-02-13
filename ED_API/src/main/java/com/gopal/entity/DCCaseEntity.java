package com.gopal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="DC_CASES")
@Data
public class DCCaseEntity {
	@Id
	@GeneratedValue
    private Long caseNum;
    private Integer planId;
    private Integer appId;
	
}
