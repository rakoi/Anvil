package com.anvil.rakoi.anvil;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anvil.rakoi.anvil.entities.Role;
import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.repos.RoleRepository;
import com.anvil.rakoi.anvil.repos.UserRepository;

@SpringBootTest
class AnvilApplicationTests {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRespostory;

	@Test
	void testGetUser() {
		try {
			Optional<User> user=userRepository.findById(1);	
			
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
	


}
