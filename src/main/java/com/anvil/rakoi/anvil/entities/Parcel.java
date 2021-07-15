package com.anvil.rakoi.anvil.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Parcel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	
	@ManyToOne
	@JoinColumn(name="reciever")
	public Client reciever;

	@ManyToOne
	@JoinColumn(name="sender")
	public Client sender;
	
	
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

	public Boolean collected;
	
	
	public Parcel(int id, Client reciever_id, Trip trip, String origin, String destination, String description,
				  String payment_method, int quantity, double amount_paid, double price, int kilograms, String timeStamp) {
		super();
		this.id = id;
		this.reciever = reciever_id;
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

	public Parcel(int id, Client reciever, Client sender, Trip trip, String origin, String destination, String description, String payment_method, int quantity, double amount_paid, double price, int kilograms, String timestamp, Boolean collected) {
		this.id = id;
		this.reciever = reciever;
		this.sender = sender;
		this.trip = trip;
		this.origin = origin;
		this.destination = destination;
		this.description = description;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timestamp;
		this.collected = collected;
	}

	public Boolean getCollected() {
		return collected;
	}

	public void setCollected(Boolean collected) {
		this.collected = collected;
	}

	public Parcel() {
	
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Parcel(String origin, String destination, String description, String payment_method, int quantity, double amount_paid, double price, int kilograms) {
		this.origin = origin;
		this.destination = destination;
		this.description = description;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.collected=false;
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
	public Client getReciever() {
		return reciever;
	}
	public void setReciever(Client reciever) {
		this.reciever = reciever;
	}

	public Parcel(Client reciever, Client sender, String origin, String destination, String description, String payment_method, int quantity, double amount_paid, double price, int kilograms, String timestamp) {
		this.reciever = reciever;
		this.sender = sender;
		this.origin = origin;
		this.destination = destination;
		this.description = description;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timestamp;
		this.collected=false;

	}

	@Override
	public String toString() {
		return "Parcel{" +
				"id=" + id +
				", reciever=" + reciever +
				", sender=" + sender +
				", trip=" + trip +
				", origin='" + origin + '\'' +
				", destination='" + destination + '\'' +
				", description='" + description + '\'' +
				", payment_method='" + payment_method + '\'' +
				", quantity=" + quantity +
				", amount_paid=" + amount_paid +
				", price=" + price +
				", kilograms=" + kilograms +
				", timestamp='" + timestamp + '\'' +
				'}';
	}
}
