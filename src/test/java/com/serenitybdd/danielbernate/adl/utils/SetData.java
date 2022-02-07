package com.serenitybdd.danielbernate.adl.utils;

public class SetData {


    public String setDataunits(String units) {
        String typeunits;
        switch (units) {
            case "Fahrenheit":
                typeunits = "imperial";
                break;
            case "Celsius":
                typeunits = "metric";
                break;
            default:
                typeunits = "";
                break;
        }
        return typeunits;
    }

}
