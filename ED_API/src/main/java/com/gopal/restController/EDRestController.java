package com.gopal.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopal.binding.EligResponse;
import com.gopal.service.EDService;

@RestController
public class EDRestController {
	@Autowired
	private EDService edService;
	
	@GetMapping("/eligibility/{caseNum}")
	public ResponseEntity<EligResponse> determine(Long caseNum){
		
		EligResponse response = edService.determineEligbility(caseNum);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
