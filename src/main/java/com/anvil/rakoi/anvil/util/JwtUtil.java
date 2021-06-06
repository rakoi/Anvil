package com.anvil.rakoi.anvil.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.anvil.rakoi.anvil.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtUtil {
	public String key="SECRET";
	
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	public Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public <T> T extractClaim(String token,Function<Claims,T> claimsResolver) {
			final Claims claims =extractAllClaims(token);
			return claimsResolver.apply(claims);
	}
	
	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	
	}
	
	
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims=new HashMap<>();
		return createToken(claims,userDetails.getUsername());
	}
	
	public String createToken(Map<String,Object> claims,String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, key).compact();
	}
	public boolean validateToken(String token,UserDetails userDetails) {
			
		String username=extractUsername(token);
		//System.out.println("Expired Status is "+isTokenExpired(token));
		//return (username.equals(userDetails.getAuthorities()) && !isTokenExpired(token));
		return true;
	}

	public User getUser(String token){
		String username=extractUsername(token);
		return null;
	}
	
	
}
