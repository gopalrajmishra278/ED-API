package com.gopal.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gopal.binding.EligResponse;
import com.gopal.entity.CitizenAppEntity;
import com.gopal.entity.DCCaseEntity;
import com.gopal.entity.EducationDetailsEntity;
import com.gopal.entity.IncomeDetailsEntity;
import com.gopal.entity.KidDetailsEntity;
import com.gopal.entity.PlanEntity;
import com.gopal.repo.CitizenAppRepo;
import com.gopal.repo.DCCaseRepo;
import com.gopal.repo.EducationDetailsRepo;
import com.gopal.repo.IncomeDetailsRepo;
import com.gopal.repo.KidDetailsRepo;
import com.gopal.repo.PlanRepository;

public class EDServiceImpl implements EDService {
    
	@Autowired
	private DCCaseRepo dcCaseRepo;
	
	@Autowired
	private PlanRepository planRepo;
	
	@Autowired
	private IncomeDetailsRepo incomeRepo;
	
	@Autowired
	private CitizenAppRepo citizenAppRepo;
	
	
	@Autowired
	private KidDetailsRepo kidRepo;
	
	@Autowired
	private EducationDetailsRepo educationRepo;
	
	
	//private Boolean kidAgeFlag = false;

	boolean noKids = false;
	boolean ageFlag = true;
	
	@Override
	public EligResponse determineEligbility(Long caseNum) {
		
		EligResponse response  = new EligResponse();
		
		Integer planId = null;
		String planName = null;
		Integer appId = null;
		Optional<DCCaseEntity> dcCaseEntity = dcCaseRepo.findById(caseNum);
		
		if(dcCaseEntity.isPresent()) {
			
			planId = dcCaseEntity.get().getPlanId();
			appId = dcCaseEntity.get().getAppId();
			}
		
		
		Optional<PlanEntity> planEntity = planRepo.findById(planId);
		
		if(planEntity.isPresent()) {
			
			planName = planEntity.get().getPlanName();
			
		}
		
	Optional<CitizenAppEntity> citizenApp = citizenAppRepo.findById(appId);
		
	   CitizenAppEntity citizen = citizenApp.get();

		IncomeDetailsEntity income = incomeRepo.findByCaseNum(caseNum);

		List<KidDetailsEntity> kids  = kidRepo.findByCaseNum(caseNum);
		
		if("SNAP".equals(planName)) {
			
			if(income.getSalaryIncome() > 300) {
				
				response.setPlanStatus("DENIED");
				response.setDenialReason("High Income");
			}
			
		} else if("CCAP".equals(planName)) {
			
			//boolean noKids = false;
			//boolean ageFlag = true;
			
			if(!kids.isEmpty()) {
				
				kids.forEach(kid -> {
					
					LocalDate dob = kid.getKidDob();
					
					LocalDate today = LocalDate.now();
					
					Period p = Period.between(dob, today);
					int year = p.getYears();
					
					if(year > 16) {
						
						ageFlag = false;
						
					}
					
				});
				
				}
			
			
			
			
			else {
				
				response.setDenialReason("No Kid Available");
				noKids = true;
				
			}
			
			if(income.getSalaryIncome() > 300) {
				
				response.setDenialReason("High Income");
				
			}
			
          if(!ageFlag) {
				
				response.setDenialReason("kid Age > 16");
			}
			
			
            if(!ageFlag && income.getSalaryIncome() > 300) {
				
				response.setDenialReason("High Income + No Kid Available");
				
			}
			
		} else if("Medicad".equals(planName)) {
			
			LocalDate dob = citizen.getDob();
			LocalDate now = LocalDate.now();
			
			Period between = Period.between(dob, now);
			
			int year = between.getYears();
			
			if(year < 65) {
				
				response.setDenialReason("Not Eligible, Age Should be greater than 65 years");			
				
			}
			
		 } else if("Medicare".equals(planName)) {
			
			    LocalDate dob = citizen.getDob();
				LocalDate now = LocalDate.now();
				
				Period between = Period.between(dob, now);
				
				int year = between.getYears();
				
				if(year < 65) {
					
					response.setDenialReason("Not Eligible, Age Should be greater than 65 years");			
					
				}
				
			
			
			
		}
		 else if("RIW".equals(planName)) {
		      
			 EducationDetailsEntity educationEntity = educationRepo.findByCaseNum(caseNum);
			 
			 Integer graduationYear = educationEntity.getGraduationYear();
			 
			 if(graduationYear <= 0) {
				 
				 response.setDenialReason("Not Graduated");
			 }
			 
			 if(income.getRentIncome() > 0) {
				 
				 response.setDenialReason("Already an Employee");
				 
			 }
			 
			
		}
		
		
		response.setPlanName(planName);
		
		if(response.getDenialReason()!=null) {
			
			response.setPlanStatus("DENIED");
			
		}else {
			
			response.setPlanStatus("Approved");
			response.setPlanStartDate(LocalDate.now().plusDays(1));
			response.setPlanEndStart(LocalDate.now().plusMonths(3));
			response.setBenefitAmt(350.00);
		}
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
