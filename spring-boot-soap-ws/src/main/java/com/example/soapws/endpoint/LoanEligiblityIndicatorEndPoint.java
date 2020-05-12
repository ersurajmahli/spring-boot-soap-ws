package com.example.soapws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soapws.loaneligibility.Acknowledgement;
import com.example.soapws.loaneligibility.CustomerRequest;
import com.example.soapws.service.LoanEligiblityService;

@Endpoint
public class LoanEligiblityIndicatorEndPoint {
	
	private static final String NAME_SPACE = "http://www.example.com/soapws/loaneligibility";
	
	@Autowired
	private LoanEligiblityService service;
	
	@PayloadRoot(namespace = NAME_SPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkEligiblity(request);
	}

}
