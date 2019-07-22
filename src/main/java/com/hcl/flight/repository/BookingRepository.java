package com.hcl.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flight.entity.User;
import com.hcl.flight.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
	
	public List<Booking> findByUser(User user);

}
