package com.anvil.rakoi.anvil.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Role implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String name;
	
	
	@JsonBackReference 
	@ManyToMany(mappedBy="roles",fetch = FetchType.EAGER)
	public Set<User> users;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
    public String getAuthority() {
        return name;
    }
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
	
	

	
}
