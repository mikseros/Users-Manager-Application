package com.mikseros.usermanagerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikseros.usermanagerapp.model.User;
import com.mikseros.usermanagerapp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAll() {
		return (List<User>) userRepository.findAll();
	}

	public void save(User user) {
		userRepository.save(user);
	}
}
