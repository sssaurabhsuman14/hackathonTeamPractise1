package com.hcl.flight.controller;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< Updated upstream
import com.hcl.flight.entity.Flight;
import com.hcl.flight.exception.ApplicationException;
import com.hcl.flight.model.SearchFlightModel;
=======
import com.hcl.flight.model.FlightDTO;
>>>>>>> Stashed changes
import com.hcl.flight.service.FlightService;
import com.hcl.flight.utility.ObjectUtility;
import com.hcl.flight.validation.Validation;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
<<<<<<< Updated upstream
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
		SearchFlightModel searchFlightModel = new SearchFlightModel(source, destination, LocalDate.parse(flightDate), sortByParam);
		Validation.validateSearchFlightModel(searchFlightModel);
		flight = (Flight) ObjectUtility.mappingObjects(searchFlightModel, flight);
		flightService.searchFlight(flight);
		
		return null;
=======
	@PostMapping
	public ResponseEntity<String> addFlight(@PathVariable Long userId, @Valid @RequestBody FlightDTO flightDTO) {
		String str= "";
		//validation for user
		flightService.addFlight(userId, flightDTO);
		
		return new ResponseEntity<String>("Flight added successfully", HttpStatus.OK); 
>>>>>>> Stashed changes
	}
	
	

}
