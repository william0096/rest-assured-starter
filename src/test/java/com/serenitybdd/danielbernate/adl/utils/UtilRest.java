package com.serenitybdd.danielbernate.adl.utils;

import com.google.gson.Gson;

import java.util.Map;

public class UtilRest {

    public static <T> String convertJson(T objeto) {
        final Gson gson = new Gson();
        return gson.toJson(objeto);
    }

    public static Map convertJsonMap(String objeto) {
        final Gson gson = new Gson();
        return gson.fromJson(objeto, Map.class);
    }

}
