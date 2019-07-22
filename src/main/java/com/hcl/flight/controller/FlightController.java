package com.hcl.flight.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flight.entity.Flight;
import com.hcl.flight.exception.ApplicationException;
import com.hcl.flight.model.ResponseData;
import com.hcl.flight.model.SearchFlightModel;
import com.hcl.flight.model.FlightDTO;
import com.hcl.flight.service.FlightService;
import com.hcl.flight.utility.ObjectUtility;
import com.hcl.flight.validation.Validation;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	/*
	 * @PostMapping public String addFlight(@PathVariable Long
	 * userId, @Valid @RequestBody Flight flight) { String str= ""; //validation for
	 * user flightService.addFlight(userId, flight);
	 * 
	 * return flightService.addFlight(userId, flight); }
	 */
	
	@GetMapping("/")
	public ResponseEntity<Object> searchFlights(
			@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("flightDate") String flightDate,
			@RequestParam("sortByParam") String sortByParam) throws ApplicationException
	{
		Flight flight = new Flight();
		SearchFlightModel searchFlightModel = new SearchFlightModel(source, destination, LocalDate.parse(flightDate));
		Validation.validateSearchFlightModel(searchFlightModel);
		flight = (Flight) ObjectUtility.mappingObjects(searchFlightModel, flight);
		
		List<Flight> searchFlightList = flightService.searchFlight(flight, sortByParam);
		
		ResponseData response = new ResponseData("Please find below Available flights for "+source+"->"+destination, HttpStatus.OK, searchFlightList);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<String> addFlight(@PathVariable Long userId, @Valid @RequestBody FlightDTO flightDTO) {
		flightService.addFlight(userId, flightDTO);
        
		return new ResponseEntity<String>("Flight added successfully", HttpStatus.OK); 
	}
	
	

}
