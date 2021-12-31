package com.anvil.rakoi.anvil.entities.Pojos;

public class StkPushSyncResp {
    public String MerchantRequestID;
    public String ResponseDescription;
    public String ResponseCode;
    public String CustomerMessage;

    public StkPushSyncResp() {
    }

    public StkPushSyncResp(String merchantRequestID, String responseDescription, String responseCode, String customerMessage) {
        MerchantRequestID = merchantRequestID;
        ResponseDescription = responseDescription;
        ResponseCode = responseCode;
        CustomerMessage = customerMessage;
    }

    public String getMerchantRequestID() {
        return MerchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        MerchantRequestID = merchantRequestID;
    }

    public String getResponseDescription() {
        return ResponseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        ResponseDescription = responseDescription;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getCustomerMessage() {
        return CustomerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        CustomerMessage = customerMessage;
    }
}
