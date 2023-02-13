package com.gopal.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Table(name="ED_ELIG_DTLS")
@Entity
@Data
public class EDEligDtlsEntity {
	@Id
	@GeneratedValue
	private Integer edTraceId;
	private Long caseNum;
	private String holderName;
	private Integer holderSsn;
	private String planName;
    private String planStatus;
	private Date planStartDate;
	private Date planEndDate;
	private Double benifitAmt;
	private String denialReason;

}
