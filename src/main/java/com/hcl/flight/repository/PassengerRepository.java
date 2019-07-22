package com.hcl.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.flight.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
