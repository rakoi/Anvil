package com.anvil.rakoi.anvil.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String first_name;
	public String last_name;
	public String email;
	public String id_number;
	public String phone;
	public int type;
	
	@JsonIgnore
	@OneToMany(mappedBy= "reciever",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Parcel> parcel=new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy= "sender",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Parcel> sentparcel=new HashSet<>();



	
	
	
	
	public Client() {
		super();
	}






	public Client(int id, String first_name, String last_name, String email, String id_number, String phone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.id_number = id_number;
		this.phone = phone;
	}

	public Client(String first_name, String last_name, String email, String id_number, String phone) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.id_number = id_number;
		this.phone = phone;
	}

	public Client(String first_name, String last_name, String email, String id_number, String phone, int type, Set<Parcel> parcel, Set<Parcel> sentparcel) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.id_number = id_number;
		this.phone = phone;
		this.type = type;
		this.parcel = parcel;
		this.sentparcel = sentparcel;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone_number) {
		this.phone = phone_number;
	}
	public Set<Parcel> getParcel() {
		return parcel;
	}
	public void setParcel(Set<Parcel> parcel) {
		this.parcel = parcel;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getNames(){
		return this.first_name+" "+this.last_name;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", email='" + email + '\'' +
				", id_number='" + id_number + '\'' +
				", phone='" + phone + '\'' +
				", type=" + type +
				'}';
	}
}
