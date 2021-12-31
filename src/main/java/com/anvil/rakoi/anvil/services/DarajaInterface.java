package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Pojos.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface DarajaInterface {

    MpesaAccessToken getAccessToken() throws IOException;
    RegisterUrlResponse registerUrl() throws IOException;
    SimulateTransactionResponse simulatec2BTransaction (SimulateTransactionRequest simulateTransactionRequest) throws IOException;

    StkPushSyncResp performStkPushTransaction(IntenalPushRequest intenalPushRequest) throws JsonProcessingException;



}
