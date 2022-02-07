package com.serenitybdd.danielbernate.adl.taks;

import com.serenitybdd.danielbernate.adl.utils.Constants;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBasket implements Task {

    public static GetBasket forCountry()
    {
        return instrumented(GetBasket.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.useRelaxedHTTPSValidation();

        actor.attemptsTo(
                Get.resource(Constants.URL_BASQUET_GET + actor.recall(Constants.COUNTRY))
        );

    }
}