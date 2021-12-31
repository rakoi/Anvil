package com.anvil.rakoi.anvil.entities.Pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimulateTransactionRequest {

    @JsonProperty("ShortCode")
    private String ShortCode;

    @JsonProperty("Msisdn")
    private String Msisdn;

    @JsonProperty("BillRefNumber")
    private String BillRefNumber;

    @JsonProperty("Amount")
    private String Amount;


    @JsonProperty("CommandID")
    private String CommandID;

    public String getShortCode() {
        return ShortCode;
    }

    public void setShortCode(String shortCode) {
        ShortCode = shortCode;
    }

    public String getMsisdn() {
        return Msisdn;
    }

    public void setMsisdn(String msisdn) {
        Msisdn = msisdn;
    }

    public String getBillRefNumber() {
        return BillRefNumber;
    }

    public void setBillRefNumber(String billRefNumber) {
        BillRefNumber = billRefNumber;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getCommandID() {
        return CommandID;
    }

    public void setCommandID(String commandID) {
        CommandID = commandID;
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }


}