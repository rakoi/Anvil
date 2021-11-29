package com.anvil.rakoi.anvil.entities.Pojos;

public class RegisterUrlResponse {
    public String confirmationId;
    public String responseDescription;
    public String originatorConversionId;


    public RegisterUrlResponse(String confirmationId, String responseDescription, String originatorConversionId) {
        this.confirmationId = confirmationId;
        this.responseDescription = responseDescription;
        this.originatorConversionId = originatorConversionId;
    }
}
