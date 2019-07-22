package com.hcl.flight.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;


@Table(name = "booking")
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookingId")
public class Booking {
	
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "flight_id")
	Flight bookFlight;
}
