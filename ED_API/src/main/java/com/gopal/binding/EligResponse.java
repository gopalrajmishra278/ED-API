package com.gopal.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EligResponse {
	
	private Long caseNum;
	private String holderName;
	private Integer holderSsn;
	private String PlanName;
	private String PlanStatus;
	private LocalDate planStartDate;
	private LocalDate planEndStart;
    private Double benefitAmt;
    private String denialReason;
	
	
}
