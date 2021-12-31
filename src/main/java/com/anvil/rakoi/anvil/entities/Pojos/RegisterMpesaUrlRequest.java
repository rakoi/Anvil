package com.anvil.rakoi.anvil.entities.Pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RegisterMpesaUrlRequest {


    public Integer ShortCode;
    public String ResponseType;
    public String ConfirmationURL;
    public String ValidationURL;

    @Autowired
    private Environment environment;


    public RegisterMpesaUrlRequest() {
    }

    public RegisterMpesaUrlRequest(Integer shortCode, String validationURL, String confirmationURL, String responseType) {
        this.ShortCode = shortCode;
        this.ValidationURL = validationURL;
        this.ConfirmationURL = confirmationURL;
        this.ResponseType = responseType;
    }

    public Integer getShortCode() {
        return ShortCode;
    }

    public void setShortCode(Integer shortCode) {
        this.ShortCode = shortCode;
    }

    public String getValidationURL() {
        return ValidationURL;
    }

    public void setValidationURL(String validationURL) {
        this.ValidationURL = validationURL;
    }

    public String getConfirmationURL() {
        return ConfirmationURL;
    }

    public void setConfirmationURL(String confirmationURL) {
        this.ConfirmationURL = confirmationURL;
    }

    public String getResponseType() {
        return ResponseType;
    }

    public void setResponseType(String responseType) {
        this.ResponseType = responseType;
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }


    @Override
    public String toString() {
        return "RegisterMpesaUrlRequest{" +
                "shortCode='" + ShortCode + '\'' +
                ", validationURL='" + ValidationURL + '\'' +
                ", confirmationURL='" + ConfirmationURL + '\'' +
                ", responseType='" + ResponseType + '\'' +
                '}';
    }


}
