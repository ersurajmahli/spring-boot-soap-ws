package com.example.soapws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.soapws.loaneligibility.Acknowledgement;
import com.example.soapws.loaneligibility.CustomerRequest;

@Service
public class LoanEligiblityService {
	
	public Acknowledgement checkEligiblity(CustomerRequest request) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteria = acknowledgement.getCriteriaMismatch();
		if(!(request.getAge()>30 && request.getAge()<=60)) {
			mismatchCriteria.add("Person age should in between 30 to 60");
		}
		if(!(request.getYearlyIncome()>200000)) {
			mismatchCriteria.add("Minimum Income should be more than 2 Lacs");
		}
		if(!(request.getCibilScore()>500)) {
			mismatchCriteria.add("Apply after 6 months");
		}
		if(mismatchCriteria.size()>0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		}else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteria.clear();
		}
		return acknowledgement;
	}

}
