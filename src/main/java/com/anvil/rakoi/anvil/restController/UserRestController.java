package com.anvil.rakoi.anvil.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Page<User> getUsers(Pageable pageable) {
		
		return userServiceImp.getAllUsers(pageable);
	}
	@GetMapping("/get/{id}")
	public User getUsers(@PathVariable("id") int id) {

		return userServiceImp.findById(id);
	}

	
}
