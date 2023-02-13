package com.gopal.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="CO_TRIGGERS")
@Data
public class COTrigEntity {
	@Id
	private Integer coTrgId;
	private Long caseNum;
	private byte[] coPdf;
	private String trgStatus;	

}
