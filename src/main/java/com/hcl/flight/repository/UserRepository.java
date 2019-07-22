package com.hcl.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.flight.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findUserByUserNameAndPassword(String userName,String password);

}
