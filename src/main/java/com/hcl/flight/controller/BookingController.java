package com.hcl.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flight.entity.Booking;
import com.hcl.flight.model.PassengerDTO;
import com.hcl.flight.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/")
	public ResponseEntity<?> doFlightBooking(@RequestParam(value="flightId") Long flightId, @RequestParam(value="userId") Long userId, @RequestBody List<PassengerDTO> passengerList) throws Exception{

		Booking booking = new Booking(); 

			
				booking = bookingService.doFlightBooking(userId, flightId, passengerList);
			
				
				if(null!=booking)
				{
				
				   return new ResponseEntity<>(booking,HttpStatus.OK);
				}
				else
				{
					
					 return new ResponseEntity<>("Not Done",HttpStatus.OK);
				}
	
}
}
