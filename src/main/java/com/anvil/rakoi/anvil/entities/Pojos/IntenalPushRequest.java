package com.anvil.rakoi.anvil.entities.Pojos;

public class IntenalPushRequest {

    public String amount;
    public String phoneNumber;

    public IntenalPushRequest() {
    }

    public IntenalPushRequest(String amount, String phoneNumber) {
        this.amount = amount;
        this.phoneNumber = phoneNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
