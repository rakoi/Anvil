package com.anvil.rakoi.anvil.entities;

public class AuthenticationResponse {

	public String jwt;
	
	

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
}
