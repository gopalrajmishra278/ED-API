package com.gopal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "INCOME_SALARY")
@Data
public class IncomeDetailsEntity {
	
	@Id
	@GeneratedValue
	private Integer incomeId;
	
	private Double salaryIncome;
	
	private Double rentIncome;
	
	private Double propertyIncome;
	
	
	private Long caseNum;
	

}
