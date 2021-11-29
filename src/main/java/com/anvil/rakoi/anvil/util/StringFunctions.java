package com.anvil.rakoi.anvil.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
       return dtf.format(now);

    }

    public static String generateTrackingNumber(String id){
        return "AVL"+id;
    }
}
