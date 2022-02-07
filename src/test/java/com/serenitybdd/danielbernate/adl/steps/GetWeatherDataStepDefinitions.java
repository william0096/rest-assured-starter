package com.serenitybdd.danielbernate.adl.steps;

import com.serenitybdd.danielbernate.adl.taks.GetWeatherData;
import com.serenitybdd.danielbernate.adl.utils.SetData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.TheResponse;

import java.io.File;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class GetWeatherDataStepDefinitions {
    Actor Daniel = Actor.named("Qa Automation Adl");


    @Given("un usuario que desea consultar el clima")
    public void a_user_wants_to_check_the_weather() {
        Daniel.whoCan(CallAnApi.at("http://api.openweathermap.org"));
    }

    @When("el consulta los datos meteorologicos de la ciudad {word}")
    public void he_consults_the_weather_data_for_the_city(String city) {
        Daniel.attemptsTo(GetWeatherData.forData(city, null,null, null, null,null, null));
    }

    @Then("obtiene el clima de la ciudad {word}")
    public void get_the_wheather_for_the_city(String city) {
        Daniel.should(seeThat(TheResponse.statusCode(), equalTo(200)));

    }

    @When("el consulta los datos meteorologicos de la ciudad {word} en unidades {word}")
    public void he_consults_the_weather_data_for_the_city_and_units(String city, String units) {
        SetData setdata = new SetData();
        String dataunits = setdata.setDataunits(units);
        Daniel.attemptsTo(GetWeatherData.forData(city, dataunits, null, null, null, null, null));
    }

    @When("el consulta los datos meteorologicos de la ciudad {word} en el {word} de USA")
    public void he_consults_the_weather_data_for_city_and_statecode_usa(String city, String statecode) {
        Daniel.attemptsTo(GetWeatherData.forData(city, null, null, statecode, null, null, null));
    }

    @When("el consulta los datos meteorologicos de la ciudad {word} en el pais {word}")
    public void he_consults_the_weather_data_for_the_city_and_country(String city,  String country ) {
        Daniel.attemptsTo(GetWeatherData.forData(city, null, country, null, null, null, null));
    }

    @Then("obtiene el clima de la ciudad {word} en el pais {word}")
    public void get_the_weather_of_the_city_country(String city, String country) {
        Daniel.should(seeThat(TheResponse.statusCode(), equalTo(200)));
    }

    @When("el consulta los datos meteorologicos por coordenadas geograficas {word} y {word}")
    public void he_consults_the_weather_data_for_lat_and_long(String lat,  String lon ) {
        Daniel.attemptsTo(GetWeatherData.forData(null, null,null, null, lat, lon, null));
    }

    @When("el consulta los datos meteorologicos por codigo {word}")
    public void he_consults_the_weather_data_for_zip(String zip) {
        Daniel.attemptsTo(GetWeatherData.forData(null, null, null, null, null, null, zip));
    }

    @Then("la validacion del jschema es satisfactoria")
    public void validy_jsonschema_ok() {
        Daniel.should(seeThatResponse(response -> response.body(JsonSchemaValidator
                .matchesJsonSchema(new File("src/test/resources/schema.json")))));
    }


}
