package com.serenitybdd.danielbernate.adl.taks;

import com.serenitybdd.danielbernate.adl.models.RequestBodyBasket;
import com.serenitybdd.danielbernate.adl.models.ClimateStatistics;
import com.serenitybdd.danielbernate.adl.utils.Constants;
import com.serenitybdd.danielbernate.adl.utils.UtilRest;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutBasket  implements Task {

    private ClimateStatistics climateStatistics;

    public PutBasket(ClimateStatistics dataTemp) {
        this.climateStatistics = dataTemp;
    }

    public static PutBasket whith(RequestBodyBasket requestBodyBasket) {
        return instrumented(PutBasket.class, requestBodyBasket.build());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.useRelaxedHTTPSValidation();

        actor.attemptsTo(
                Put.to(Constants.URL_BASQUET_PUT + actor.recall(Constants.COUNTRY))
                        .with(
                                request ->
                                        request
                                                .header("Content-Type", "application/json")
                                                .body(UtilRest.convertJson(climateStatistics))));

    }

}
