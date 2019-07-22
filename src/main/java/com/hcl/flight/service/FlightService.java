package com.hcl.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.entity.Flight;
import com.hcl.flight.repository.FlightRepository;
import com.hcl.flight.validation.Validation;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	Validation validation;
	
	public String addFlight(Long userId, Flight flight) {
		String msg ="";
		//Validation
		return msg;
	}

public boolean updateFlightByNumberOfSeats(Flight flight, Integer numberOfSeatsBooked) {
		
		if( flight != null) {
			Integer updatedAvailableSeats = flight.getAvailableSeats() - numberOfSeatsBooked;
			flight.setAvailableSeats(updatedAvailableSeats);
			flightRepository.save(flight);
			return true;
		}
		return false;
	}

}
