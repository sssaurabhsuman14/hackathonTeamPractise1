package com.hcl.flight.model;

import com.hcl.flight.enums.UserRole;

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
public class UserDTO {

private Long userId;
	
	private String userName;
	
	private String password;
	
	private Integer userAge;
	
	private Long userGender;
	
	private UserRole userRole;
	
}
