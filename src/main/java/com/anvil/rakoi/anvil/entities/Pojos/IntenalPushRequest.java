package com.anvil.rakoi.anvil.entities.Pojos;

public class IntenalPushRequest {

    public String amount;
    public String phoneNumber;
    public String mpesaCode;
    public IntenalPushRequest() {
    }


    public IntenalPushRequest(String amount, String phoneNumber, String mpesaCode) {
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.mpesaCode = mpesaCode;
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



    public String getMpesaCode() {
        return mpesaCode;
    }

    public void setMpesaCode(String mpesaCode) {
        this.mpesaCode = mpesaCode;
    }

    @Override
    public String toString() {
        return "IntenalPushRequest{" +
                "amount='" + amount + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mpesaCode='" + mpesaCode + '\'' +
                '}';
    }
}
