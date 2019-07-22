package com.hcl.flight.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hcl.flight.entity.Booking;
import com.hcl.flight.entity.Flight;
import com.hcl.flight.entity.Passenger;
import com.hcl.flight.entity.User;
import com.hcl.flight.model.PassengerDTO;
import com.hcl.flight.repository.BookingRepository;
import com.hcl.flight.repository.FlightRepository;
import com.hcl.flight.repository.UserRepository;
import com.hcl.flight.utility.FareUtils;
import com.hcl.flight.validation.Validation;

@Service
public class BookingService {

	
	@Autowired
	BookingRepository bookingrepossitory;
	
	@Autowired
	FlightService flightservice;
	
	@Autowired
	FlightRepository flightrepository;
	
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	Validation validation;
	
	@Autowired
	FareUtils fareUtils;
	
	
	
	public Booking doFlightBooking(Long userId, Long flightId, List<PassengerDTO> passengers) {
	
		Booking booked = null;
		Flight flight=flightrepository.findById(flightId).get();
		User user=userrepository.findById(userId).get();
		boolean isFlightByAvailableSeats = false;
		
		if(null!=flight)
		{
			isFlightByAvailableSeats = validation.validateFlightByAvailableSeats(flight.getAvailableSeats(),passengers.size());
		}
		else
		{
			//TODO Flight not avaliable
		}
		
		if(isFlightByAvailableSeats)
		{
			List <Passenger> passengerList = mappingPassengerModelListToPassengerList(passengers);

			Double totalFare = fareUtils.calculateTotalFare(flight.getFare(),passengers.size());
			
			Booking booking = new Booking();
			booking.setBookingDate(LocalDate.now());
			booking.setUser(user);
			booking.setBookFlight(flight);
			booking.setSeatBooked(passengers.size());
			booking.setTotalFare(totalFare);
			booking.setPassengers(passengerList);
			booked=bookingrepossitory.save(booking);
			
			try {
				
			    flightservice.updateFlightByNumberOfSeats(flight, passengers.size());
			}
			
			catch(Exception ex) {
				//TODO Flight Entity not updated
			}
			
		}
		else
		{
			//TODO Seats not available
		}
		
		return booked;
		
		
		
		
		
	}
	
	
	private List<Passenger> mappingPassengerModelListToPassengerList(List<PassengerDTO> passengers) 
	{
		List<Passenger> passangerList = new ArrayList<>();
		
		for(PassengerDTO passModel: passengers)
		{
			Passenger pass = new Passenger();
			pass.setPassengerAge(passModel.getPassengerAge());
			pass.setPassengerGender(passModel.getPassengerGender());
			pass.setPassengerName(passModel.getPassengerName());
			
			passangerList.add(pass);
		}
		return passangerList;

}
}
