package com.hcl.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flight.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping
	public String addFlight() {
		String str= "";
		return str; 
	}
	

}
