package com.anvil.rakoi.anvil.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.text.CharacterPredicate;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class StringFunctions {
    public static String getQueryParam(String string){

        String [] parts=string.split("\\?");
        return parts[0];
    }
    public static String getPageNumber(String string) {
        String [] parts;
        try{
             parts=string.split("\\?")[1].split("=");
        }catch (Exception e){
            return "0";
        }


        return parts[1];
    }
    public static String getCurrentTime(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
       return dtf.format(now);

    }

    public static String generateTrackingNumber(String id){
        return "AVL"+id;
    }

    public static String toBase64String(String value){
        byte[] data=value.getBytes(StandardCharsets.ISO_8859_1);
        return Base64.encode(data);
    }

    public static String getTransactionUniqueNo(){
        RandomStringGenerator randomStringGenerator=new RandomStringGenerator.Builder()
                .withinRange('0','z')
                .filteredBy(CharacterPredicates.LETTERS,CharacterPredicates.DIGITS)
                .build();
        return randomStringGenerator.generate(12).toUpperCase();
    }

    public static String getStkPushPassword(String shortCode,String passKey,String timeStamp){

        String concatenated=shortCode+passKey+timeStamp;
        return toBase64String(concatenated);

    }

    public static String getCurrentTimestamp(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(new Date());
    }


}
