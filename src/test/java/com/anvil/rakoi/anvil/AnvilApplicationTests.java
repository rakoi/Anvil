package com.anvil.rakoi.anvil;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.repos.UserRepository;

@SpringBootTest
class AnvilApplicationTests {
	
	@Autowired
	UserRepository userRepository;

	@Test
	void testGetUser() {
		Optional<User> user=userRepository.getUserByUsername("brianrakoi");
		System.out.println(user);
	}
	


}
