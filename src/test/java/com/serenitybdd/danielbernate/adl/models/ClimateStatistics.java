package com.serenitybdd.danielbernate.adl.models;

public class ClimateStatistics {
    private String city;
    private String country;
    private String celsius;
    private String farenheit;

    public ClimateStatistics(RequestBodyBasket requestBodyBasket) {
        this.city = requestBodyBasket.getCity();
        this.country = requestBodyBasket.getCountry();
        this.celsius = requestBodyBasket.getCelsius();
        this.farenheit = requestBodyBasket.getFarenheit();
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCelsius() {
        return celsius;
    }

    public String getFarenheit() {
        return farenheit;
    }
}
