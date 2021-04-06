package com.anvil.rakoi.anvil.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String email;
	public String username;
	public String password;
	public boolean active;
	
	
	@JsonManagedReference 
	@ElementCollection(targetClass=Role.class)
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> roles;
	
	
	
	public User(int id, String email, String username, String password, boolean active, Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", active=" + active + ", roles="
				+ roles + "]";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	

}