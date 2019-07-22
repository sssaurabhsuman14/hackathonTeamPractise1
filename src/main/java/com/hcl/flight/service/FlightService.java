package com.hcl.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;

}
