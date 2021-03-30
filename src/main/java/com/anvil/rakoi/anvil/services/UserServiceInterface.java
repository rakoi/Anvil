package com.anvil.rakoi.anvil.services;

import java.util.List;
import java.util.Optional;

import com.anvil.rakoi.anvil.entities.User;

public interface UserServiceInterface {

	User findById(int id);
	List<User> getAllUsers();
	Optional<User> getUserByUsername(String username);
}
