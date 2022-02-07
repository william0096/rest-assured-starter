package com.serenitybdd.danielbernate.adl.taks;

import com.serenitybdd.danielbernate.adl.models.RequestBodyBasket;
import com.serenitybdd.danielbernate.adl.models.ClimateStatistics;
import com.serenitybdd.danielbernate.adl.utils.Constants;
import com.serenitybdd.danielbernate.adl.utils.UtilRest;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostBasket implements Task {

    private ClimateStatistics climateStatistics;

    public PostBasket(ClimateStatistics dataTemp) {
        this.climateStatistics = dataTemp;
    }

    public static PostBasket whith(RequestBodyBasket requestBodyBasket) {
        return instrumented(PostBasket.class, requestBodyBasket.build());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.useRelaxedHTTPSValidation();

        actor.attemptsTo(
                Post.to(Constants.URL_BASQUET_POST + actor.recall(Constants.COUNTRY))
                        .with(
                                request ->
                                        request
                                                .header("Content-Type", "application/json")
                                                .body(UtilRest.convertJson(climateStatistics))));

    }
}
