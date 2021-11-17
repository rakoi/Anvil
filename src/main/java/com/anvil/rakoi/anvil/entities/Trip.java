package com.anvil.rakoi.anvil.entities;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;

	public String destination;
	public String origin;
	public String depature;
	public String arrival;
	public String timestamp;
	public String completed;
	@Transient
	public double tripExpense;

	@JsonIgnoreProperties("expenses")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "trip")

	public Set<Expenses> expenses=new HashSet<>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy="trip",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Parcel> parcel=new HashSet<>();
	@JsonIgnoreProperties("trips")
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	public Vehicle vehicle;

	public Trip() {
		super();
	}

	public Trip(int id, String destination, String origin, String depature, String arrival, String timestamp, String completed, Set<Expenses> expenses, Set<Parcel> parcel, Vehicle vehicle) {
		this.id = id;
		this.destination = destination;
		this.origin = origin;
		this.depature = depature;
		this.arrival = arrival;
		this.timestamp = timestamp;
		this.completed = completed;
		this.expenses = expenses;
		this.parcel = parcel;
		this.vehicle = vehicle;
	}

	public Trip(String destination, String origin, String depature, String arrival, String timestamp, String completed, Vehicle vehicle) {
		this.destination = destination;
		this.origin = origin;
		this.depature = depature;
		this.arrival = arrival;
		this.timestamp = timestamp;
		this.completed = completed;
		this.vehicle = vehicle;
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

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}



	public Set<Parcel> getParcel() {
		return parcel;
	}

	public void setParcel(Set<Parcel> parcel) {
		this.parcel = parcel;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public double getTripExpense() {

		float totalExpenses=0;
		this.expenses.forEach((expenses -> {
			increaseExpense(Float.parseFloat(expenses.getCost()));

		}));
		return tripExpense;
	}

	public void increaseExpense(Float expense){
			this.tripExpense=this.tripExpense+expense;
	}




	public Set<Expenses> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expenses> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "Trip{" +
				"id=" + id +
				", destination='" + destination + '\'' +
				", origin='" + origin + '\'' +
				", depature='" + depature + '\'' +
				", arrival='" + arrival + '\'' +
				", timestamp='" + timestamp + '\'' +
				", completed='" + completed + '\'' +
				", tripExpense=" + tripExpense +
				", expenses=" + expenses +
				", parcel=" + parcel +
				", vehicle=" + vehicle +
				'}';
	}
}
