package com.hcl.flight.validation;

import org.springframework.stereotype.Component;

@Component
public class Validation 
{

	public boolean validateFlightByAvailableSeats(Integer availableSeats , Integer requestedSeats) {

		if(availableSeats !=  null && requestedSeats != null && availableSeats >= requestedSeats) {
			return true;
		}
		return false;
		
		
	}
	
	 
}
