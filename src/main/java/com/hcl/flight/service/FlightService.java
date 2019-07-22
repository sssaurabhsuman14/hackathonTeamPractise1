package com.hcl.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hcl.flight.entity.Flight;
import com.hcl.flight.entity.User;
import com.hcl.flight.enums.UserRole;
import com.hcl.flight.exception.ApplicationException;
import com.hcl.flight.exception.DataInsertException;
import com.hcl.flight.model.FlightDTO;
import com.hcl.flight.repository.FlightRepository;
import com.hcl.flight.repository.UserRepository;
import com.hcl.flight.utility.ObjectUtility;
import com.hcl.flight.utility.ObjectUtils;
import com.hcl.flight.validation.Validation;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ObjectUtility objectUtility;


	@Autowired
	Validation validation;

	public String addFlight(Long userId, FlightDTO flightDTO) {

		Optional<User> user = userRepository.findById(userId);
		if (user.get().getUserRole().equals(UserRole.ADMIN)) {
			if(validation.checkValidationsForAddingFlight(flightDTO)) {
				Flight flight = new Flight();

				flight = (Flight) objectUtility.mappingObjects(flightDTO, flight);

				flightRepository.save(flight);
			} else {
				throw new DataInsertException("Error while saving flight details. " );
			}
		}
		String msg ="SUCCESSFUL SAVING.";
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
	public List<Flight> searchFlight(Flight flight, String sortByParam) throws ApplicationException 
	{
		
		List<Flight> flightList = (List<Flight>) ObjectUtility.checkOptional(checkSortByParam(flight, sortByParam));
		

		if(flightList != null)
			return flightList;
		else
			throw new ApplicationException("No Flights Available for : "+flight.getSource()+"->"+flight.getDestination());
	
	}

	private Optional<List<Flight>> checkSortByParam(Flight flight, String sortByParam) throws ApplicationException 
	{
		Sort sortParam = Sort.by(Sort.Direction.ASC, "fare");
		switch(sortByParam)
		{
		case "fare":
			sortParam = Sort.by(Sort.Direction.ASC, "fare");
			return flightRepository.findBySourceAndDestinationAndAvailableSeatsIsGreaterThanAndStatusEquals(flight.getSource(), flight.getDestination(),0, "approved", sortParam);
		
		case "departure":
			sortParam = Sort.by(Sort.Direction.ASC, "departure");
			return flightRepository.findBySourceAndDestinationAndAvailableSeatsIsGreaterThanAndStatusEquals(flight.getSource(), flight.getDestination(),0, "approved", sortParam);
		
		case "seats":
			sortParam = Sort.by(Sort.Direction.DESC, "available_seats");
			return flightRepository.findBySourceAndDestinationAndAvailableSeatsIsGreaterThanAndStatusEquals(flight.getSource(), flight.getDestination(),0, "approved", sortParam);
		
		default :
			throw new ApplicationException("Please select the proper sorting parameter");
		}
		


	}

}
