package com.anvil.rakoi.anvil.services;

import java.util.List;

import com.anvil.rakoi.anvil.entities.User;

public interface UserServiceInterface {

	User findById(int id);
	List<User> getAllUsers();
}
