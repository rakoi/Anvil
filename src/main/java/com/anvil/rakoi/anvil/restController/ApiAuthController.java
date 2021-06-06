package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.services.ClientServiceImp;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.anvil.rakoi.anvil.entities.AuthenticationRequest;
import com.anvil.rakoi.anvil.entities.AuthenticationResponse;
import com.anvil.rakoi.anvil.security.MyDetailsService;
import com.anvil.rakoi.anvil.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

@RequestMapping("/api")
public class ApiAuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	public MyDetailsService myDetailsService;
	@Autowired
	public JwtUtil jwtUtil;
	@Autowired
	ClientServiceImp clientServiceImp;
	
	

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
			
			JSONObject obj=new JSONObject();  
			  obj.put("error","Incorrect Credentials");
			
			return ResponseEntity.ok(obj);
			//throw new Exception("Incorrect username password");
			
		}

	}

	@GetMapping(value = "/getUserDetails")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<?> getUserDetails(){

		Object user= SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		clientServiceImp.getAllClients();
		return ResponseEntity.ok(user);
	}
}
