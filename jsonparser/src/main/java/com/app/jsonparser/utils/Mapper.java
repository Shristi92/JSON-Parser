package com.app.jsonparser.utils;

import org.json.JSONObject;

import java.util.Date;

public class Mapper {

    public static int setIntValueToData(JSONObject jsonObject, String key) {
        if(jsonObject.has(key)) {
            return jsonObject.optInt(key);
        }
        return -1;
    }

    public static String setStringValueToData(JSONObject jsonObject, String key) {
        if(jsonObject.has(key)) {
            return jsonObject.optString(key);
        }
        return "";
    }

    public static Date setDateValueToData(JSONObject jsonObject, String key) {
        if(jsonObject.has(key)) {
            String s = jsonObject.optString(key);
            return BasicUtilities.convertStringToDate(s);
        }
        return null;
    }

}
