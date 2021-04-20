package com.anvil.rakoi.anvil.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parcel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	
	@ManyToOne
	@JoinColumn(name="client_id")
	public Client client;
	
	
	@ManyToOne
	@JoinColumn(name="trip_id")
	public Trip trip;
	
	

	
	public String origin;
	public String destination;
	public String description;
	public String payment_method;
	public int quantity;
	public double amount_paid;
	public double price;
	public int kilograms;
	public String timestamp;
	
	
	public Parcel(int id, Client client, Trip trip, String origin, String destination, String description,
			String payment_method, int quantity, double amount_paid, double price, int kilograms, String timeStamp) {
		super();
		this.id = id;
		this.client = client;
		this.trip = trip;
		this.origin = origin;
		this.destination = destination;
		this.description = description;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timeStamp;
	}
	
	
	
	public Parcel(int id, Trip trip, String origin, String destination, String description, String payment_method,
			int quantity, double amount_paid, double price, int kilograms, String timeStamp) {
		super();
		this.id = id;
		this.trip = trip;
		this.origin = origin;
		this.destination = destination;
		this.description = description;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timeStamp;
	}


	

	public Parcel() {
	
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(double amount_paid) {
		this.amount_paid = amount_paid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getKilograms() {
		return kilograms;
	}
	public void setKilograms(int kilograms) {
		this.kilograms = kilograms;
	}
	public String getTimeStamp() {
		return timestamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timestamp = timeStamp;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
