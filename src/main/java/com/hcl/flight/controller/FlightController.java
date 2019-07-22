package com.hcl.flight.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flight.entity.Flight;
import com.hcl.flight.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping
	public String addFlight(@PathVariable Long userId, @Valid @RequestBody Flight flight) {
		String str= "";
		//validation for user
		flightService.addFlight(userId, flight);
		
		return flightService.addFlight(userId, flight); 
	}
	

}
