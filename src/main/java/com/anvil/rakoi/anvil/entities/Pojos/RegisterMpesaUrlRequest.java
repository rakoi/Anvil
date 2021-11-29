package com.anvil.rakoi.anvil.entities.Pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RegisterMpesaUrlRequest {


    public String shortCode;
    public String validationURL;
    public String confirmationURL;

    public String responseType;
    @Autowired
    private Environment environment;


    public RegisterMpesaUrlRequest() {
    }

    public RegisterMpesaUrlRequest(String shortCode, String validationURL, String confirmationURL, String responseType) {
        this.shortCode = shortCode;
        this.validationURL = validationURL;
        this.confirmationURL = confirmationURL;
        this.responseType = responseType;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getValidationURL() {
        return validationURL;
    }

    public void setValidationURL(String validationURL) {
        this.validationURL = validationURL;
    }

    public String getConfirmationURL() {
        return confirmationURL;
    }

    public void setConfirmationURL(String confirmationURL) {
        this.confirmationURL = confirmationURL;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }


    @Override
    public String toString() {
        return "RegisterMpesaUrlRequest{" +
                "shortCode='" + shortCode + '\'' +
                ", validationURL='" + validationURL + '\'' +
                ", confirmationURL='" + confirmationURL + '\'' +
                ", responseType='" + responseType + '\'' +
                '}';
    }


}
