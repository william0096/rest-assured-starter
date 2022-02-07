package com.serenitybdd.danielbernate.adl.steps;

import com.serenitybdd.danielbernate.adl.models.RequestBodyBasket;
import com.serenitybdd.danielbernate.adl.taks.DeleteBasket;
import com.serenitybdd.danielbernate.adl.taks.GetBasket;
import com.serenitybdd.danielbernate.adl.taks.PostBasket;
import com.serenitybdd.danielbernate.adl.taks.PutBasket;
import com.serenitybdd.danielbernate.adl.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.TheResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class BasketStepDefinitions {

    Actor Daniel = Actor.named("Qa Automation Adl");

    @Given("un usuario que tiene el reporte del clima de la ciudad {word} en el pais {word}")
    public void a_user_who_has_the_weather_report_for_the_city_in_the_country (String city, String country) {
        Daniel.whoCan(CallAnApi.at(Constants.URL_BASQUET));
        Daniel.remember(Constants.CITY, city);
        Daniel.remember(Constants.COUNTRY, country);
    }

    @And("posee la temperatura en grados celsius {word}")
    public void possesses_the_temperature_in_degrees_celsiu(String celcius) {
        Daniel.remember(Constants.CELSIUS, celcius);

    }

    @And("tambien la temperatura en grado Farhenheit {word}")
    public void possesses_the_temperature_in_degrees_farenheit(String farhenheit) {
        Daniel.remember(Constants.FARHENHEIT, farhenheit);
    }

    @When("el envia la peticion para almacenar los datos meteorologicos")
    public void he_sends_the_request_to_store_the_meteorological_data() {
        Daniel.attemptsTo(PostBasket.whith(RequestBodyBasket.WhitData()
                .city(Daniel.recall(Constants.CITY))
                .country(Daniel.recall(Constants.COUNTRY))
                .tempcelsius(Daniel.recall(Constants.CELSIUS))
                .tempfarenheit(Daniel.recall(Constants.FARHENHEIT))));
    }


    @Then("obtiene el guardado exitoso en un basket")
    public void successfully_saves_in_a_basket()
    {
        Daniel.should(seeThat(TheResponse.statusCode(), equalTo(200)));
    }


    @When("el envia la peticion para consultar los datos meteorologicos")
    public void the_submit_request_for_weather_data() {
        Daniel.attemptsTo(GetBasket.forCountry());
    }

    @Then("obtiene la informacion de los datos almacenados del clima")
    public void get_the_information_from_stored_weather_data() {
        Daniel.should(seeThat(TheResponse.statusCode(), equalTo(200)));
    }

    @When("el envia la peticion para actualizar los datos meteorologicos {word} y {word}")
    public void the_send_request_to_update_the_weather_data_and(String celsius, String farhenheit) {
        Daniel.attemptsTo(PutBasket.whith(RequestBodyBasket.WhitData()
                .city(Daniel.recall(Constants.CITY))
                .country(Daniel.recall(Constants.COUNTRY))
                .tempcelsius(celsius)
                .tempfarenheit(farhenheit)));

    }
    @Then("obtiene la informacion de los datos actualizados del clima")
    public void get_the_information_on_updated_weather_data() {
        Daniel.should(seeThat(TheResponse.statusCode(), equalTo(200)));
    }

    @When("el envia la peticion para eliminar el registro")
    public void the_send_request_for_delet_of_the_register() {
        Daniel.attemptsTo(DeleteBasket.forCountry());

    }
    @Then("los datos son eliminados del basket")
    public void the_data_is_removed_from_basket() {
        Daniel.should(seeThat(TheResponse.statusCode(), equalTo(200)));
    }


}
