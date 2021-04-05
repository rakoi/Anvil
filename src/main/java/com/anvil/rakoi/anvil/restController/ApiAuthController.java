package com.anvil.rakoi.anvil.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anvil.rakoi.anvil.entities.AuthenticationRequest;
import com.anvil.rakoi.anvil.entities.AuthenticationResponse;
import com.anvil.rakoi.anvil.security.MyDetailsService;
import com.anvil.rakoi.anvil.util.JwtUtil;

@RestController
public class ApiAuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	public MyDetailsService myDetailsService;
	@Autowired
	public JwtUtil jwtUtil;
	
	@RequestMapping(value="/authenticate"
			+ "",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
					);
			final UserDetails userdetails=myDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			
			
			final String jwt=jwtUtil.generateToken(userdetails);
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt));
			
		}catch(Exception e) {
			throw new Exception("Incorrect username password");
		}
		
		
		
		
	}
}
