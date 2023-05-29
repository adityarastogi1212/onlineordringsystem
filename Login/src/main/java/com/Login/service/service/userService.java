package com.Login.service.service;

import com.Login.service.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Login.service.entities.User;

@Service
public class userService {
	
	@Autowired
	private userRepository uRepository;
	
//	public User getDetail (String username, String password){
//		return this.uRepository.findByusernameAndpassword(username, password);
//	}
	
	public User username (String username){
		return this.uRepository.findByusername(username);
	}
	
	public User password (String password){
		return this.uRepository.findBypassword(password);
	}

	public User add(User user) {
		
		// TODO Auto-generated method stub
		return this.uRepository.save(user);
	}
	

}
