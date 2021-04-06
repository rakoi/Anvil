package com.anvil.rakoi.anvil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anvil.rakoi.anvil.entities.User;

public interface UserServiceInterface {

	User findById(int id);
	List<User> getAllUsers();
	Optional<User> getUserByUsername(String username);
	Page<User> getAllUsers(Pageable pageable);
}
