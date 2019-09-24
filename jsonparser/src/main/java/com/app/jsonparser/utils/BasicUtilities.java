package com.app.jsonparser.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicUtilities {

    public static Date convertStringToDate(String s) {
        return convertStringToDate(s, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
    }


    public static Date convertStringToDate(String s, SimpleDateFormat sdf) {
        Date date = null;
        if(!isStringNull(s)) {
            try {
                date = sdf.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return date;
    }

    public static boolean isStringNull(String s) {
        return s==null || s.isEmpty() || s.equalsIgnoreCase("null");
    }

}
