package com.anvil.rakoi.anvil.entities.Pojos;

public class RegisterUrlResponse {
    public String OriginatorCoversationID;
    public String ResponseDescription;
    public String ResponseCode;


    public RegisterUrlResponse(String confirmationId, String responseDescription, String originatorConversionId) {
        this.OriginatorCoversationID = confirmationId;
        this.ResponseDescription = responseDescription;
        this.ResponseCode = originatorConversionId;
    }
}
