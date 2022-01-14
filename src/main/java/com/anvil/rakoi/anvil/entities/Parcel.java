package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@JsonIgnore
	public Trip trip;

/*

	@OneToOne(mappedBy = "parcel")
	@JsonIgnoreProperties("parcel")
	public Invoice invoice;
*/



	@OneToMany(mappedBy="parcel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<mpesatransactions> mpesaTransactions=new HashSet<>();



	@ManyToOne
	@JoinColumn(name="origin_id")
	public Station origin;

	@ManyToOne
	@JoinColumn(name="destination_id")
	public Station destination;



	@OneToMany(mappedBy="parcel")
	@JsonIgnoreProperties("parcel")
	private Set<Journal> journalEntry;




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

	public Parcel(Client reciever, Client sender, Trip trip, Station origin, Station destination, String payment_method, int quantity, double amount_paid, double price, int kilograms, String timestamp, String description, Boolean collected) {
		this.reciever = reciever;
		this.sender = sender;
		this.trip = trip;
		this.origin = origin;
		this.destination = destination;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timestamp;
		this.description = description;
		this.collected = collected;
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


	public Parcel(int id, Client reciever, Client sender, Trip trip, Station origin, Station destination, String payment_method, int quantity, double amount_paid, double price, int kilograms, String timestamp, String description, Boolean collected) {
		this.id = id;
		this.reciever = reciever;
		this.sender = sender;
		this.trip = trip;
		this.origin = origin;
		this.destination = destination;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timestamp;
		this.description = description;
		this.collected = collected;
	}

	public Parcel(int id, Client reciever, Client sender, Trip trip, Set<mpesatransactions> mpesaTransactions, Station origin, Station destination, Set<Journal> journalEntry, String payment_method, int quantity, double amount_paid, double price, int kilograms, String timestamp, String description, Boolean collected) {
		this.id = id;
		this.reciever = reciever;
		this.sender = sender;
		this.trip = trip;
		this.mpesaTransactions = mpesaTransactions;
		this.origin = origin;
		this.destination = destination;
		this.journalEntry = journalEntry;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timestamp;
		this.description = description;
		this.collected = collected;
	}

	public Parcel(int id, Client reciever, Client sender, Trip trip, Station origin, Station destination, Set<Journal> journalEntry, String payment_method, int quantity, double amount_paid, double price, int kilograms, String timestamp, String description, Boolean collected) {
		this.id = id;
		this.reciever = reciever;
		this.sender = sender;
		this.trip = trip;
		this.origin = origin;
		this.destination = destination;
		this.journalEntry = journalEntry;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timestamp;
		this.description = description;
		this.collected = collected;
	}

/*
	public Parcel(int id, Client reciever, Client sender, Trip trip, Invoice invoice, Set<mpesatransactions> mpesaTransactions, Station origin, Station destination, Set<Journal> journalEntry, String payment_method, int quantity, double amount_paid, double price, int kilograms, String timestamp, String description, Boolean collected) {
		this.id = id;
		this.reciever = reciever;
		this.sender = sender;
		this.trip = trip;
		this.invoice = invoice;
		this.mpesaTransactions = mpesaTransactions;
		this.origin = origin;
		this.destination = destination;
		this.journalEntry = journalEntry;
		this.payment_method = payment_method;
		this.quantity = quantity;
		this.amount_paid = amount_paid;
		this.price = price;
		this.kilograms = kilograms;
		this.timestamp = timestamp;
		this.description = description;
		this.collected = collected;
	}
*/

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

	public Station getOrigin() {
		return origin;
	}

	public void setOrigin(Station origin) {
		this.origin = origin;
	}

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Journal> getJournalEntry() {
		return journalEntry;
	}

	public void setJournalEntry(Set<Journal> journalEntry) {
		this.journalEntry = journalEntry;
	}

	@Override
	public String toString() {
		return "Parcel{" +
				"id=" + id +
				", reciever=" + reciever +
				", sender=" + sender +
				", trip=" + trip +
				", origin=" + origin +
				", destination=" + destination +
				", payment_method='" + payment_method + '\'' +
				", quantity=" + quantity +
				", amount_paid=" + amount_paid +
				", price=" + price +
				", kilograms=" + kilograms +
				", timestamp='" + timestamp + '\'' +
				", description='" + description + '\'' +
				", collected=" + collected +
				'}';
	}

	public Set<mpesatransactions> getMpesaTransactions() {
		return mpesaTransactions;
	}

	public void setMpesaTransactions(Set<mpesatransactions> mpesaTransactions) {
		this.mpesaTransactions = mpesaTransactions;
	}

/*
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
*/
}
