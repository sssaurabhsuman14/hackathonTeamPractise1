package com.hcl.flight.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.hcl.flight.entity.User;
import com.hcl.flight.exception.ApplicationException;
import com.hcl.flight.exception.UserNotFoundException;
import com.hcl.flight.model.SearchFlightModel;
import com.hcl.flight.service.UserService;
import com.hcl.flight.utility.OptionalUtils;
import com.hcl.flight.model.FlightDTO;

@Component
public class Validation 
{
	
	@Autowired
	UserService userService;

	public boolean validateFlightByAvailableSeats(Integer availableSeats , Integer requestedSeats) {

		if(availableSeats !=  null && requestedSeats != null && availableSeats >= requestedSeats) {
			return true;
		}
		return false;
		
		
	}
	
	 
	public static void validateSearchFlightModel(SearchFlightModel searchFlightModel) throws ApplicationException 
	{
		if(!StringUtils.hasText(searchFlightModel.getSource()))
			throw new ApplicationException("Source is Mandatory");
		
		if(!StringUtils.hasText(searchFlightModel.getDestination()))
			throw new ApplicationException("Destination is Mandatory");
		
		if(!StringUtils.hasText(searchFlightModel.getFlightDate().toString()))
			throw new ApplicationException("Flight Date is Mandatory");
		
	}

	public boolean checkValidationsForAddingFlight(FlightDTO flightDTO) {	

		if(!(flightDTO.getSource().isEmpty() || flightDTO.getDestination().isEmpty() || flightDTO.getFlightNumber().isEmpty() || flightDTO.getTotalSeats()>0 || flightDTO.getFare()>0)) {
			return true;
		}
		return false;
	}
	public boolean validateUser(String userName , String password) {

		if(userName != null && password != null) {
			return true;
		}

		return false;
	}

	public boolean validateUserRole(Long userId) throws UserNotFoundException {
		
		Optional<User> userOptional = userService.getUserFromRepo(userId);
		User user = (User) OptionalUtils.checkOptional(userOptional);
		
		if(ObjectUtils.isEmpty(user)) 
		{
			throw new UserNotFoundException("User entry is not found.....");
		}
		else
		{
			if (user.getUserRole().equals("Admin")) 
				return true;
		}
		return false;
	}
}
