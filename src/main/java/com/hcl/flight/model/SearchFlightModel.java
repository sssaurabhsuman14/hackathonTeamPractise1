package com.hcl.flight.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchFlightModel 
{
	private String source;

	private String destination;
	
	private LocalDate flightDate;

}
