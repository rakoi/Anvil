package com.anvil.rakoi.anvil.entities.Pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExternalStkPushRequest {

    public Integer BusinessShortCode;

    public String Password;
    public String Timestamp;
    public String TransactionType;
    public String Amount;
    public long PartyA;
    public int PartyB;
    public String PhoneNumber;
    public String CallBackURL;
    public String AccountReference;
    public String TransactionDesc;

    public ExternalStkPushRequest() {
    }

    public ExternalStkPushRequest(Integer businessShortCode, String password, String timestamp, String transactionType, String amount, long partyA, int partyB, String phoneNumber, String callBackURL, String accountReference, String transactionDesc) {
        BusinessShortCode = businessShortCode;
        Password = password;
        Timestamp = timestamp;
        TransactionType = transactionType;
        Amount = amount;
        PartyA = partyA;
        PartyB = partyB;
        PhoneNumber = phoneNumber;
        CallBackURL = callBackURL;
        AccountReference = accountReference;
        TransactionDesc = transactionDesc;
    }

    public Integer getBusinessShortCode() {
        return BusinessShortCode;
    }

    public void setBusinessShortCode(Integer businessShortCode) {
        BusinessShortCode = businessShortCode;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public long getPartyA() {
        return PartyA;
    }

    public void setPartyA(long partyA) {
        PartyA = partyA;
    }

    public int getPartyB() {
        return PartyB;
    }

    public void setPartyB(int partyB) {
        PartyB = partyB;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCallBackURL() {
        return CallBackURL;
    }

    public void setCallBackURL(String callBackURL) {
        CallBackURL = callBackURL;
    }

    public String getAccountReference() {
        return AccountReference;
    }

    public void setAccountReference(String accountReference) {
        AccountReference = accountReference;
    }

    public String getTransactionDesc() {
        return TransactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        TransactionDesc = transactionDesc;
    }



    @Override
    public String toString() {
        return "StkPushRequest{" +
                "BusinessShortCode='" + BusinessShortCode + '\'' +
                ", Password='" + Password + '\'' +
                ", Timestamp='" + Timestamp + '\'' +
                ", TransactionType='" + TransactionType + '\'' +
                ", Amount='" + Amount + '\'' +
                ", PartyA=" + PartyA +
                ", PartyB=" + PartyB +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", CallBackURL='" + CallBackURL + '\'' +
                ", AccountReference='" + AccountReference + '\'' +
                ", TransactionDesc='" + TransactionDesc + '\'' +
                '}';
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

}
