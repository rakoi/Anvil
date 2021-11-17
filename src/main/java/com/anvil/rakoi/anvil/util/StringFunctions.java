package com.anvil.rakoi.anvil.util;

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
}
