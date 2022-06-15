package com.mikseros.usermanagerapp;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.mikseros.usermanagerapp.model.User;
import com.mikseros.usermanagerapp.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testAddNew() {
		User user = new User();
		user.setEmail("ali@baba.com");
		user.setPassword("hwdp123");
		user.setFirstName("Ali");
		user.setLastName("Baba");
		
		User savedUser = userRepository.save(user);
		
		Assertions.assertThat(savedUser).isNotNull();
		Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAll() {
		Iterable<User> users = userRepository.findAll();
		Assertions.assertThat(users).hasSizeGreaterThan(0);
		
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testUpdate() {
		Integer userId = 1;
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		user.setPassword("jp321");
		userRepository.save(user);
		
		User updatedUser = userRepository.findById(userId).get();
		Assertions.assertThat(updatedUser.getPassword()).isEqualTo("jp321");
	}
	
	@Test
	public void testGet() {
		Integer userId = 2;
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		
		Assertions.assertThat(optionalUser).isPresent();
		System.out.println(optionalUser.get());
	}
}
