package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Pojos.*;
import com.anvil.rakoi.anvil.util.StringFunctions;
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
    public RegisterUrlResponse registerUrl() throws IOException {
        MpesaAccessToken accessTokenResponse = getAccessToken();

        RegisterMpesaUrlRequest mpesaRequest=new RegisterMpesaUrlRequest();
        mpesaRequest.setShortCode(Integer.parseInt(env.getProperty("SHORT_CODE")));
        mpesaRequest.setValidationURL(env.getProperty("VALIDATION_URL"));
        mpesaRequest.setConfirmationURL(env.getProperty("CONFIRMATION_URL"));
        mpesaRequest.setResponseType(env.getProperty("RESPONSE_TYPE"));

        System.out.println(mpesaRequest.toJson());
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = null;
         body = RequestBody.create(mediaType,mpesaRequest.toJson());
        Request request = new Request.Builder()
                .url(env.getProperty("REGISTER_URL"))
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", accessTokenResponse.getBearer())
                .build();
        Response response = client.newCall(request).execute();



        return null;



    }

    @Override
    public SimulateTransactionResponse simulatec2BTransaction(SimulateTransactionRequest simulateTransactionRequest) throws IOException {

        MpesaAccessToken accessTokenResponse = getAccessToken();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = null;
        body = RequestBody.create(mediaType,simulateTransactionRequest.toJson());

        Request request = new Request.Builder()
                .url(env.getProperty("SIMULATE_URL"))
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", accessTokenResponse.getBearer())
                .build();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(),SimulateTransactionResponse.class);


    }

    @Override
    public StkPushSyncResp performStkPushTransaction(IntenalPushRequest intenalPushRequest) throws JsonProcessingException {

        System.out.println("pushing");
        ExternalStkPushRequest externalStkPushReq=new ExternalStkPushRequest();
        String timeStamp=StringFunctions.getCurrentTimestamp();
        System.out.println("timestamp is"+timeStamp);
        externalStkPushReq.setBusinessShortCode(Integer.parseInt(env.getProperty("STKPUSH_SHORTCODE")));
        externalStkPushReq.setPassword(StringFunctions.getStkPushPassword(env.getProperty("STKPUSH_SHORTCODE"),env.getProperty("STKPUSH_PASSKEY"),timeStamp));
        externalStkPushReq.setTimestamp(timeStamp);
        externalStkPushReq.setTransactionType("CustomerPayBillOnline");
        externalStkPushReq.setAmount(intenalPushRequest.getAmount());
        externalStkPushReq.setPartyA(Long.valueOf(intenalPushRequest.getPhoneNumber()));
        externalStkPushReq.setPartyB(174379);
        externalStkPushReq.setPhoneNumber(intenalPushRequest.getPhoneNumber());
        externalStkPushReq.setCallBackURL(env.getProperty("STK_PUSH_REQUESTCALLBACK"));
        externalStkPushReq.setAccountReference(StringFunctions.getTransactionUniqueNo());
        externalStkPushReq.setTransactionDesc("ANVIL");

        System.out.println("callback url is "+externalStkPushReq.getCallBackURL());


        MpesaAccessToken accessTokenResponse = getAccessToken();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = null;
        body = RequestBody.create(mediaType,externalStkPushReq.toJson());


        Request request = new Request.Builder()
                .url(env.getProperty("STKPUSH_REQUESTURL"))
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", accessTokenResponse.getBearer())
                .build();


        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Response response = null;
        try {
            response = client.newCall(request).execute();


            //return null;
             return gson.fromJson(response.body().string(),StkPushSyncResp.class);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println("could not perform push");
            return  null;
        }





    }
}
