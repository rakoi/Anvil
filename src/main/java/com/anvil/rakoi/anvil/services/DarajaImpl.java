package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Pojos.MpesaAccessToken;
import com.anvil.rakoi.anvil.entities.Pojos.RegisterMpesaUrlRequest;
import com.anvil.rakoi.anvil.entities.Pojos.RegisterUrlResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class DarajaImpl implements DarajaInterface{

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    OkHttpClient okHttpClient;
    @Autowired
    Gson gson;

    @Autowired
    private Environment env;


    @Override
    public MpesaAccessToken getAccessToken() {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        //TODO REPLACE URL WITH AUTO GENERATED FROM CLASS
        //TODO :- REPLACE URL WITH AUTO GENERATED FROM CLASS
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .method("GET", null)
                .addHeader("Authorization", "Basic cFJZcjZ6anEwaThMMXp6d1FETUxwWkIzeVBDa2hNc2M6UmYyMkJmWm9nMHFRR2xWOQ==")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();

            MpesaAccessToken token= gson.fromJson(response.body().string(),MpesaAccessToken.class);
             return  token;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }


    }

    @Override
    public RegisterUrlResponse registerUrl() throws JsonProcessingException {
        MpesaAccessToken accessTokenResponse = getAccessToken();

        RegisterMpesaUrlRequest mpesaRequest=new RegisterMpesaUrlRequest();
        mpesaRequest.setShortCode(env.getProperty("SHORT_CODE"));
        mpesaRequest.setValidationURL(env.getProperty("VALIDATION_URL"));
        mpesaRequest.setConfirmationURL(env.getProperty("CONFIRMATION_URL"));
        mpesaRequest.setResponseType(env.getProperty("RESPONSE_TYPE"));




        MediaType mediaType = MediaType.parse("application/json");

       RequestBody body = RequestBody.create(mediaType,
                mpesaRequest.toJson()
        );

    System.out.println(mpesaRequest.toJson());
       Request request=new Request.Builder().url("https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl").post(body).addHeader("Authorization",accessTokenResponse.getBearer()).build();
        System.out.println(accessTokenResponse.getBearer());
        try {
            Response response=okHttpClient.newCall(request).execute();
            System.out.println(response);
            return null;
            //return gson.fromJson(response.body().string(),RegisterUrlResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
