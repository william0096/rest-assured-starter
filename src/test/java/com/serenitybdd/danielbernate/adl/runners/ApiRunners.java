package com.serenitybdd.danielbernate.adl.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com/serenitybdd/danielbernate/adl/steps")

public class ApiRunners {
    public ApiRunners(){


    }
}
