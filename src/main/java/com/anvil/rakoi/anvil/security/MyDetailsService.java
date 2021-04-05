package com.anvil.rakoi.anvil.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.repos.UserRepository;

@Service
public class MyDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		try {
			Optional<User> user=userRepository.getUserByUsername(username);
			return new MyUserDetails(user.get());
		}catch(Exception e) {
			throw new UsernameNotFoundException("Invalid Credentials");
		}
		
	}

}
