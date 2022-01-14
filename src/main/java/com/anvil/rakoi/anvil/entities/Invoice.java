package com.anvil.rakoi.anvil.entities;

import javax.persistence.*;
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parcel_id", referencedColumnName = "id")
    public Parcel parcel;

    public String date;
    public String status;



    public Invoice() {
    }

    public Invoice(int id, Parcel parcel, String date, String status) {
        this.id = id;
      //  this.parcel = parcel;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
