package com.mikseros.usermanagerapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikseros.usermanagerapp.exception.UserNotFoundException;
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
	
	public User get(Integer id) throws UserNotFoundException {
		Optional<User> result = userRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new UserNotFoundException("User with id: " + id + " not found!");
		}
	}
}
