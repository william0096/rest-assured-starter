package com.serenitybdd.danielbernate.adl.models;

public class RequestBodyBasket {

    private String city;
    private String country;
    private String celsius;
    private String farenheit;

    public RequestBodyBasket (){
        this.city = "";
        this.country = "";
        this.celsius = "";
        this.farenheit  = "";
    }

    public static RequestBodyBasket WhitData() {
        return new RequestBodyBasket();
    }

    public RequestBodyBasket city(String ciudad) {
        this.city = ciudad;
        return this;
    }

    public RequestBodyBasket country(String pais) {
        this.country = pais;
        return this;
    }

    public RequestBodyBasket tempcelsius(String tempcelsius) {
        this.celsius = tempcelsius;
        return this;
    }

    public RequestBodyBasket tempfarenheit(String tempfarenheit) {
        this.farenheit = tempfarenheit;
        return this;
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

    public ClimateStatistics build() {
        return new ClimateStatistics(this);
    }

}
