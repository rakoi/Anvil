package com.anvil.rakoi.anvil.entities.Pojos;


public class SimulateTransactionResponse {

    public String OriginatorCoversationID;
    public String ResponseCode;
     public String ResponseDescription;

    public SimulateTransactionResponse(String originatorCoversationID, String responseCode, String responseDescription) {
        OriginatorCoversationID = originatorCoversationID;
        ResponseCode = responseCode;
        ResponseDescription = responseDescription;
    }

    public String getOriginatorCoversationID() {
        return OriginatorCoversationID;
    }

    public void setOriginatorCoversationID(String originatorCoversationID) {
        OriginatorCoversationID = originatorCoversationID;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseDescription() {
        return ResponseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        ResponseDescription = responseDescription;
    }

    @Override
    public String toString() {
        return "SimulateTransactionResponse{" +
                "ResponseDescription='" + ResponseDescription + '\'' +
                ", OriginatorConverstionID='" + OriginatorCoversationID + '\'' +

                '}';
    }
}