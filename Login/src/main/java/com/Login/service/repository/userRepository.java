package com.Login.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Login.service.entities.User;

@Repository
public interface userRepository extends CrudRepository<User, Integer> {

	User findByusername(String username);
	User findBypassword(String password);
	
}
