package com.anvil.rakoi.anvil.entities;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	public int id;
	public String destination;
	public String origin;
	public String depature;
	public String arrival;
	public String timestamp;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="trip",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Parcel> parcel=new HashSet<>();
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	public Vehicle vehicle;
	
	@JsonIgnore
	@OneToOne(mappedBy="trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Expense expense;
	
	public Trip() {
		super();
	}
	public Trip(int id, String destination, String origin,String depature, String arrival,
			String timestamp) {
		super();
		this.id = id;
		this.destination = destination;
		this.origin = origin;
	
		this.depature = depature;
		this.arrival = arrival;
		this.timestamp = timestamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Set<Parcel> getParcel() {
		return parcel;
	}
	public void setParcel(Set<Parcel> parcel) {
		this.parcel = parcel;
	}
	
	
	
	

}
