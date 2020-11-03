package com.xdesign.munro.api.bdd.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
public class CucumberStepDefinitions {

    @Given( "the client searches for a munro" )
    public void theClientSearchesForAMunro() {
    }

    @When( "the client submits the request" )
    public void theClientSubmitsTheRequest() {
    }

    @Then( "the service returns a page of munros" )
    public void theServiceReturnsAPageOfMunros() {
    }

    @And( "the query parameters are invalid" )
    public void theQueryParametersAreInvalid() {

    }

    @Then( "a validation exception should be thrown" )
    public void aValidationExceptionShouldBeThrown() {

    }

    @Given( "the client searches for a munro with invalid query params" )
    public void theClientSearchesForAMunroWithInvalidQueryParams() {
    }
}
