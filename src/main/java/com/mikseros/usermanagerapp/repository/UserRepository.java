package com.mikseros.usermanagerapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.mikseros.usermanagerapp.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public Long countById(Integer id);
}
