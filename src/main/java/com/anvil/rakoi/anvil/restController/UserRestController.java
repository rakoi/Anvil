package com.anvil.rakoi.anvil.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.services.UserServiceImp;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	UserServiceImp userServiceImp;
	
	@GetMapping("/all")
	public List<User> getUsers() {
		return userServiceImp.getAllUsers();
	}
	
}
