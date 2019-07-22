package com.hcl.flight.utility;

import org.springframework.stereotype.Component;

@Component
public class FareUtils {
	
	public Double calculateTotalFare(Double fare, Integer numberOfPassengers) {
		return (fare*numberOfPassengers);
	}

}
