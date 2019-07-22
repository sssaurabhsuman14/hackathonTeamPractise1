package com.hcl.flight.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "booking")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookingId")
public class Booking {
	
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	@Column(name = "BOOKING_DATE", nullable = false)
	private LocalDate bookingDate;

	@Column(name = "SEAT_BOOKED", nullable = false)
	private Integer seatBooked;

	@Column(name = "TOTAL_FARE", nullable = false)
	private Double totalFare;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "flight_id")
	Flight bookFlight;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "booking")
	List<Passenger> passengers;
}
