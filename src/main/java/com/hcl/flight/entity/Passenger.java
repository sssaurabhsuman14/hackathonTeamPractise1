package com.hcl.flight.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "passenger")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "passengerId")
public class Passenger {
	
	@Id
	@Column(name="passenger_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passengerId;
	
	@Column(name="passenger_name", nullable = false)
	private String PassengerName;

	@Column(name="passenger_age", nullable = false)
	private Integer passengerAge;
	
	@Column(name="passenger_gender", nullable = false)
	private String passengerGender;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
	Booking booking;

		
	

}