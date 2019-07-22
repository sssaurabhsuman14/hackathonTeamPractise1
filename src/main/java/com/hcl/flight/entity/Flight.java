package com.hcl.flight.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flight")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "flightId")
public class Flight implements Serializable
{
	
	@Id
	@Column(name="flight_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long flightId;
	
	@Column(name="flight_number", nullable = false)
	private String flightNumber;
	
	@Column(name="source", nullable = false)
	private String source;
	
	@Column(name="destination", nullable = false)
	private String destination;
	
	@Column(name="departure", nullable = false)
	private LocalTime departure;
	
	@Column(name="arrival", nullable = false)
	private LocalTime arrival;
	
	@Column(name="total_seats", nullable = false)
	private Integer totalSeats;
	
	@Column(name="available_seats", nullable = false)
	private Integer availableSeats;
	
	@Column(name="fare", nullable = false)
	private Double fare;
	
	@Column(name="status", nullable = false)
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "bookFlight")
	private List<Booking> bookingHistory;
	
	

}
