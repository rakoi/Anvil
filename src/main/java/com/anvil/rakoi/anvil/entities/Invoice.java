package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;


    @OneToMany(mappedBy="invoice")
    private Set<Parcel> parcels;

  public String date;
    public Boolean status;

    @ManyToOne
    @JoinColumn(name="client")
    public Client client;

    public Invoice(int id, Set<Parcel> parcels, String date, Boolean status) {
        this.id = id;
        this.parcels = parcels;
        this.date = date;
        this.status = status;
    }

    public Invoice() {
    }

    public Invoice(int id, String date, Boolean status, Client client) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDate() throws ParseException {
        Date date1=new SimpleDateFormat("yyyymmdd").parse(date);
        return date1.toString();
    }

    public String getClientNames(){
        return client.getNames();
    }

    public Set<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(Set<Parcel> parcels) {
        this.parcels = parcels;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
public Float getTotal(){
        float total = 0;
        for(Parcel parcel :parcels){
            total+=parcel.price;
        }

        return total;
    }

}
