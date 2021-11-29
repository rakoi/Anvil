package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.Pojos.MpesaAccessToken;
import com.anvil.rakoi.anvil.entities.Pojos.RegisterUrlResponse;
import com.anvil.rakoi.anvil.services.DarajaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/payment")
public class MpesaRestController {

    @Autowired
    DarajaImpl darajaImpl;
    @GetMapping("/token")

    public MpesaAccessToken initiate() throws IOException {

    return darajaImpl.getAccessToken();
    }

    @GetMapping("/registerurl")
    public RegisterUrlResponse regUrl() throws IOException {

        return darajaImpl.registerUrl();
    }
}
