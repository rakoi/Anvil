package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity

public class mpesatransactions {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    public double amount;
    public  String phoneNumber;
    public String MpesaReceiptNumber;
    public String MerchantRequestID;
    public String date;


    @ManyToOne
    @JoinColumn(name="parcel_id")
    @JsonIgnore
    public Parcel parcel;

    public mpesatransactions(int id, double amount, String phoneNumber, String mpesaReceiptNumber, String merchantRequestID, Parcel parcel) {
        this.id = id;
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        MpesaReceiptNumber = mpesaReceiptNumber;
        MerchantRequestID = merchantRequestID;
        this.parcel = parcel;
    }

    public mpesatransactions() {
    }

    public mpesatransactions(int id, double amount, String phoneNumber, String mpesaReceiptNumber, String merchantRequestID, String date, Parcel parcel) {
        this.id = id;
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        MpesaReceiptNumber = mpesaReceiptNumber;
        MerchantRequestID = merchantRequestID;
        this.date = date;
        this.parcel = parcel;
    }

    public mpesatransactions(int id, double amount, String phoneNumber, String mpesaReceiptNumber, String merchantRequestID) {
        this.id = id;
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        MpesaReceiptNumber = mpesaReceiptNumber;
        MerchantRequestID = merchantRequestID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMpesaReceiptNumber() {
        return MpesaReceiptNumber;
    }

    public void setMpesaReceiptNumber(String mpesaReceiptNumber) {
        MpesaReceiptNumber = mpesaReceiptNumber;
    }

    public String getMerchantRequestID() {
        return MerchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        MerchantRequestID = merchantRequestID;
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

    @Override
    public String toString() {
        return "mpesatransactions{" +
                "id=" + id +
                ", amount=" + amount +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", MpesaReceiptNumber='" + MpesaReceiptNumber + '\'' +
                ", MerchantRequestID='" + MerchantRequestID + '\'' +
                ", date='" + date + '\'' +
                ", parcel=" + parcel +
                '}';
    }
}

