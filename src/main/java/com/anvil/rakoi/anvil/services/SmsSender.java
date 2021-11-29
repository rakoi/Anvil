package com.anvil.rakoi.anvil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsSender {
    @Autowired
    private Environment env;


   public  boolean sendMessage(String to,String Text){


     String ACCOUNT_SID =  env.getProperty("TWILIO_ACCOUNT_SID");
     String AUTH_TOKEN = env.getProperty("TWILIO_AUTH_TOKEN");
     String FROM=env.getProperty("TWILO_PHONE");

     System.out.println("Account sid is "+ACCOUNT_SID);
     System.out.println("Auth token is "+AUTH_TOKEN);
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       try{
           Message message = Message.creator(new PhoneNumber(to),
                   new PhoneNumber(FROM),
                   Text).create();
           System.out.println(message.getSid());

       }catch (Exception e){
           System.out.println(e.toString());
           return  false;
       }




       return  true;
   }

}
