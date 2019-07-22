package com.hcl.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.entity.Flight;
import com.hcl.flight.exception.ApplicationException;
import com.hcl.flight.repository.FlightRepository;
import com.hcl.flight.utility.ObjectUtility;
import com.hcl.flight.exception.DataInsertException;
import com.hcl.flight.model.FlightDTO;
import com.hcl.flight.repository.FlightRepository;
import com.hcl.flight.utility.ObjectUtils;
import com.hcl.flight.validation.Validation;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ObjectUtils objectUtils;


	@Autowired
	Validation validation;

	public String addFlight(Long userId, FlightDTO flightDTO) {


		if(validation.checkValidationsForAddingFlight(flightDTO)) {
			Flight flight = new Flight();

			flight = (Flight) ObjectUtils.mappingObjects(flightDTO, flight);

			flightRepository.save(flight);
		} else {
			throw new DataInsertException("Error while saving flight details. " );
		}
		String msg ="";
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
	public List<Flight> searchFlight(Flight flight) throws ApplicationException 
	{
		Optional<List<Flight>> findBySourceAndDestinationOptional = flightRepository.findBySourceAndDestination(flight.getSource(), flight.getDestination());
		List<Flight> flightList = (List<Flight>) ObjectUtility.checkOptional(findBySourceAndDestinationOptional);
		
		if(flightList != null)
			return flightList;
		else
			throw new ApplicationException("No Flights Available for : "+flight.getSource()+"->"+flight.getDestination());
		
		
	}

}
