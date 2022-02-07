package com.serenitybdd.danielbernate.adl.taks;

import com.serenitybdd.danielbernate.adl.utils.Constants;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteBasket  implements Task {

    public static DeleteBasket forCountry()
    {
        return instrumented(DeleteBasket.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.useRelaxedHTTPSValidation();

        actor.attemptsTo(
                Delete.from(Constants.URL_BASQUET_DELETE + actor.recall(Constants.COUNTRY))
        );

    }
}
