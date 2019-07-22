package com.hcl.flight.model;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

	private String flightNumber;
	private String source;
	private String destination;
	private LocalTime departure;
	private LocalTime arrival;
	private Integer totalSeats;
	private Integer availableSeats;
	private Double fare;
	private String status;
}
