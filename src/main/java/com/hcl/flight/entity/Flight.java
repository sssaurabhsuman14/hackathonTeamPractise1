package com.hcl.flight.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Flight implements Serializable
{
	
	private Long flightId;
	private String flightNumber;
	private String source;
	private String destination;
	private LocalTime departure;
	private LocalTime arrival;
	private Integer totalSeats;
	private Integer availableSeats;
	private Double fare;
	private String status;
	private List<Booking> bookingHistory;
	
	

}
