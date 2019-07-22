package com.hcl.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.flight.entity.User;
import com.hcl.flight.service.UserService;
import com.hcl.flight.validation.Validation;



@RestControllerAdvice
@RequestMapping("/login")
public class loginController {

	@Autowired
	UserService userService;
	
	@Autowired
	Validation validation; 
	
	
	@GetMapping("/user")
	public ResponseEntity<?> loginUser(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password){
		User user = new User();
		user= userService.getUserFromRepoOnUsernameAndPassword(userName, password);
		
		if(validation.validateUser(user.getUserName(),user.getPassword())){
			if(user.getUserRole()=="User") {
				return new ResponseEntity<>(userService.loginUser(userName, password), HttpStatus.OK);
			}
			
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
		
	}
	
}
