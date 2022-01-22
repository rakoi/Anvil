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


	@ManyToOne
	@JsonIgnoreProperties("parcels")
	@JoinColumn(name="invoice_id", nullable=true)
	public Invoice invoice;



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

	public Parcel() {
	}

	public Invoice getInvoice() {
//		if(this.invoice!=null&&this.invoice.getId()>0){
//			return invoice;
//		}
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Set<mpesatransactions> getMpesaTransactions() {
		return mpesaTransactions;
	}

	public void setMpesaTransactions(Set<mpesatransactions> mpesaTransactions) {
		this.mpesaTransactions = mpesaTransactions;
	}

	public Set<Journal> getJournalEntry() {
		return journalEntry;
	}

	public void setJournalEntry(Set<Journal> journalEntry) {
		this.journalEntry = journalEntry;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCollected() {
		return collected;
	}

	public void setCollected(Boolean collected) {
		this.collected = collected;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getReciever() {
		return reciever;
	}

	public void setReciever(Client reciever) {
		this.reciever = reciever;
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

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public Station getOrigin() {
		return origin;
	}

	public void setOrigin(Station origin) {
		this.origin = origin;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}
