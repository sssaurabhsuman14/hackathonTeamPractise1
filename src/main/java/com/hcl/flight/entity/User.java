package com.hcl.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hcl.flight.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable=false)
	private Long userId;
	
	@Column(name = "user_name", nullable=false)
	private String userName;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	@Column(name = "user_age", nullable=false)
	private Integer userAge;
	
	@Column(name = "user_gender", nullable=false)
	private String userGender;
	
	@Column(name = "user_role", nullable=false)
	private String userRole;
	
	
}
