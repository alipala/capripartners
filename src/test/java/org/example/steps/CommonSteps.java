package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.picocontainer.*;
import io.restassured.response.Response;
import org.example.steps.utils.ApiTestHelper;

import static org.hamcrest.Matchers.*;

public class CommonSteps {

    private ApiTestHelper apiTestHelper;
    private Response response;

    public CommonSteps() {
        this.apiTestHelper = new ApiTestHelper("");
    }

    @Given("I have a valid API key")
    public void i_have_a_valid_api_key() {
        apiTestHelper.setApiKey("");
    }

    @Given("I have an invalid API key")
    public void i_have_an_invalid_api_key() {
        apiTestHelper = new ApiTestHelper("HELLLOOOO");
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = apiTestHelper.sendGetRequest(endpoint);
        this.response = response;
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    public ApiTestHelper getApiTestHelper() {
        return apiTestHelper;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}

