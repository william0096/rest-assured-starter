package com.serenitybdd.danielbernate.adl.taks;

import com.serenitybdd.danielbernate.adl.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetWeatherData implements Task {

    private final String city;
    private final String units;
    private final String country;
    private final String state;
    private final String latitud;
    private final String longitud;
    private final String zip;

    public GetWeatherData(String city, String units,
                          String country, String state, String latitud,
                          String longitud, String zip) {
        this.city = city;
        this.units = units;
        this.country = country;
        this.state = state;
        this.latitud = latitud;
        this.longitud = longitud;
        this.zip = zip;
    }


    public static GetWeatherData forData(String city, String units, String country, String state,
                                         String latitud, String longitud, String zip)
    {
        return instrumented(GetWeatherData.class, city, units, country, state,
                latitud, longitud, zip);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constants.URL_WEATHER).with(
                        request ->
                                request
                                        .queryParam(Constants.QUERY_PARAMS_Q, city)
                                        .queryParam(Constants.QUERY_PARAMS_APPID, Constants.APPID)
                                        .queryParam(Constants.QUERY_PARAMS_LANG, Constants.LANG)
                                        .queryParam(Constants.QUERY_PARAMS_UNITS, units)
                                        .queryParam(Constants.QUERY_PARAMS_LATITUD, latitud)
                                        .queryParam(Constants.QUERY_PARAMS_LONGITUD, longitud)
                                        .queryParam(Constants.QUERY_PARAMS_ZIP, zip)
                )
        );


    }
}
