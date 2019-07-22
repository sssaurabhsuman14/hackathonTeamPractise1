package com.hcl.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.entity.Booking;
import com.hcl.flight.entity.Flight;
import com.hcl.flight.entity.User;
import com.hcl.flight.exception.ApplicationException;
import com.hcl.flight.exception.UserNotFoundException;
import com.hcl.flight.repository.BookingRepository;
import com.hcl.flight.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	
	BookingRepository bookingRepository;
	
	@Autowired
	FlightService flightService;
	
public List<Booking> loginUser(String  userName, String password) throws UserNotFoundException{
		
		User loginUser = userRepository.findUserByUserNameAndPassword(userName, password);
			
				if(loginUser!= null) 
				{
					return bookingRepository.findByUser(loginUser);
				}else {
					throw new UserNotFoundException("No user found !!!");
				}
			}
	
	
	public Optional<User> getUserFromRepo(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user;
	}
	
	public User getUserFromRepoOnUsernameAndPassword(String userName, String password) {
		User user = userRepository.findUserByUserNameAndPassword(userName, password);
		return user;
	}
	
	public List<Flight> getFlightByStatusNotApproved() throws ApplicationException{
		
		List<Flight> flights = flightService.getFlightByStatusNotApproved();
		return flights;
		
	}
}
