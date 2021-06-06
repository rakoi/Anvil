package com.anvil.rakoi.anvil.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String reg_no;
	public String make;
	
	
	
	public String date_assigned;
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicle")
	public Set<Trip> Trips=new HashSet();
	
	@JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	public User user;


	 
	 
	
	public Vehicle() {
		super();
	}


	public Set<Trip> getTrips() {
		return Trips;
	}

	public void setTrips(Set<Trip> trips) {
		Trips = trips;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

	public String getDate_assigned() {
		return date_assigned;
	}
	public void setDate_assigned(String date_assigned) {
		this.date_assigned = date_assigned;
	}


	
}
