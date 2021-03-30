package com.anvil.rakoi.anvil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.repos.UserRepository;

@Service
public class UserServiceImp implements UserServiceInterface {
	

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findById(int id) {
		
		return userRepository.getOne(id);
	}

	@Override
	public List<User> getAllUsers() {
	
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

}
