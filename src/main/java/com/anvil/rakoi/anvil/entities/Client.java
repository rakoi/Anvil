package com.anvil.rakoi.anvil.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String first_name;
	public String last_name;
	public String email;
	public String id_number;
	public String phone_number;
	
	@JsonIgnore
	@OneToMany(mappedBy="client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Parcel> parcel=new HashSet<>();
	
	
	
	
	
	
	public Client() {
		super();
	}
	public Client(int id, String first_name, String last_name, String email, String id_number, String phone_number) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.id_number = id_number;
		this.phone_number = phone_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Set<Parcel> getParcel() {
		return parcel;
	}
	public void setParcel(Set<Parcel> parcel) {
		this.parcel = parcel;
	}
	
	
	

}