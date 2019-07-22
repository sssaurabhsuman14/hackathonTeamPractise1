package com.hcl.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flight.entity.Booking;
import com.hcl.flight.entity.User;
import com.hcl.flight.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	
	BookingRepository bookingRepository;
	
	public List<Booking> loginUser(String  userName, String password){
		
		User login = userRepository.findUserByUserNameAndPassword(userName, password);
			if(login!=null) {
				if(login!= null) 
				{
					return bookingRepository.findByUser(loginUser);
				}else {
					throw new Exception("No user found !!!");
				}
	}
	
	public Optional<User> getUserFromRepo(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user;
	}
	
	public User getUserFromRepoOnUsernameAndPassword(String userName, String password) {
		User user = userRepository.findUserByUserNameAndPassword(userName, password);
		return user;
	}
}
