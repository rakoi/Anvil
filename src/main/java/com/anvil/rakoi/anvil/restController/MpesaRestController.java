package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.Pojos.*;
import com.anvil.rakoi.anvil.entities.mpesatransactions;
import com.anvil.rakoi.anvil.repos.MpesaTransactionsRepository;
import com.anvil.rakoi.anvil.services.DarajaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/payment")
public class MpesaRestController  {


    @Autowired
    MpesaTransactionsRepository mpesaTransactionsRepository;



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

    @PostMapping(value = "/validation",produces = "application/json")
    public ResponseEntity<?> validation(@RequestBody MpesaValidationResponse mpesaValidationResponse) throws IOException {
        System.out.println("called validation");
        System.out.println(mpesaValidationResponse.toString());
        return ResponseEntity.ok("success");
    }
    @PostMapping(value = "/simulateCustomer2Business",produces = "application/json")
    public SimulateTransactionResponse simulateCustomerTransaction(@RequestBody SimulateTransactionRequest simulateTransactionRequest)  {


        try {
            return darajaImpl.simulatec2BTransaction(simulateTransactionRequest);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/transactionResults",produces = "application/json")
    public ResponseEntity<String> acknowledgeStkPushResp(@RequestBody StkPushAsyncResponse stkPushAsyncResponse)  {

            System.out.println("this is a callback");
        System.out.println(stkPushAsyncResponse.toString());

        mpesatransactions transaction=new mpesatransactions();
        double amount;
        String phoneNumber;
        String receiptNumber;
        String merchantRequestid;
        String date;

        if(stkPushAsyncResponse.getBody().getStkCallback().getResultCode().equals("0")){

            transaction.setMerchantRequestID(stkPushAsyncResponse.getBody().getStkCallback().getMerchantRequestID());
            for(ItemItem item : stkPushAsyncResponse.getBody().getStkCallback().getCallbackMetaData().getItem()){
                if(item.getName().equals("Amount")){
                    transaction.setAmount(Double.parseDouble(item.getValue()));

                }
                if(item.getName().equals("MpesaReceiptNumber")){
                    transaction.setMpesaReceiptNumber(item.getValue());
                }

                if(item.getName().equals("PhoneNumber")){
                    transaction.setPhoneNumber(item.getValue());
                }

                if(item.getName().equals("TransactionDate")){
                    transaction.setDate(item.getValue());
                }
            }

            System.out.println(transaction.toString());
            mpesaTransactionsRepository.save(transaction);

        }


       // System.out.println(stkPushAsyncResponse.getBody().getStkCallback().toString());
            return ResponseEntity.ok("Success");

    }
    @PostMapping(value = "/initiatePushRequest",produces = "application/json")
    public ResponseEntity<StkPushSyncResp> performStkPushTransaction(@RequestBody IntenalPushRequest intenalPushRequest)  {


        try {
            return ResponseEntity.ok( darajaImpl.performStkPushTransaction(intenalPushRequest));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
