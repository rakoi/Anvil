package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Pojos.MpesaAccessToken;
import com.anvil.rakoi.anvil.entities.Pojos.RegisterUrlResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface DarajaInterface {

    MpesaAccessToken getAccessToken() throws IOException;
    RegisterUrlResponse registerUrl() throws JsonProcessingException;
}
