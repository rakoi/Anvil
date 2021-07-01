package com.anvil.rakoi.anvil.entities;

public class SaveParcelEntity {

    Client sender;
    Client Reciever;
    Parcel parcel;

    public SaveParcelEntity(Client sender, Client reciever, Parcel parcel) {
        this.sender = sender;
        Reciever = reciever;
        this.parcel = parcel;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getReciever() {
        return Reciever;
    }

    public void setReciever(Client reciever) {
        Reciever = reciever;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    @Override
    public String toString() {
        return "SaveParcelEntity{" +
                "sender=" + sender.toString() +
                ", Reciever=" + Reciever.toString() +
                ", parcel=" + parcel.toString() +
                '}';
    }
}
