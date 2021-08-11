package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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



	@ManyToOne
	@JoinColumn(name="origin_id")
	public Station origin;

	@ManyToOne
	@JoinColumn(name="destination_id")
	public Station destination;



	public String payment_method;
	public int quantity;
	public double amount_paid;
	public double price;
	public int kilograms;
	public String timestamp;
	public String description;

	public Boolean collected;

	public Parcel(Client reciever, Client sender, Trip trip, Station origin, Station destination, String payment_method, int kilograms) {
		this.reciever = reciever;
		this.sender = sender;
		this.trip = trip;
		this.origin = origin;
		this.destination = destination;
		this.payment_method = payment_method;
		this.kilograms = kilograms;
	}

	public Parcel(Client reciever, Client sender, Station origin, Station destination, String payment_method, int quantity, double amount_paid, double price, int kilograms, String description) {
		this.reciever = reciever;
		this.sender = sender;
		this.origin = origin;
		this.destination = destination;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.description = description;
	}

	public Parcel(Client reciever, Client sender, Station origin, Station destination, String payment_method, int quantity, double amount_paid, double price, int kilograms) {
		this.reciever = reciever;
		this.sender = sender;
		this.origin = origin;
		this.destination = destination;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
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

	@Override
	public String toString() {
		return "Parcel{" +
				"id=" + id +
				", reciever=" + reciever +
				", sender=" + sender +
				", trip=" + trip +
				", origin='" + origin + '\'' +

				", payment_method='" + payment_method + '\'' +
				", quantity=" + quantity +
				", amount_paid=" + amount_paid +
				", price=" + price +
				", kilograms=" + kilograms +
				", timestamp='" + timestamp + '\'' +
				'}';
	}
}
