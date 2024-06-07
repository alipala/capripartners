package org.example.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.example.steps.utils.ApiTestHelper;

public class CommonSteps {

    private ApiTestHelper apiTestHelper;
    private Response response;

    public CommonSteps() {
        this.apiTestHelper = new ApiTestHelper("jw4VW7dk");
    }

    @Given("I have a valid API key")
    public void i_have_a_valid_api_key() {
        apiTestHelper.setApiKey("jw4VW7dk");
    }

    @Given("I have an invalid API key")
    public void i_have_an_invalid_api_key() {
        apiTestHelper = new ApiTestHelper("HELLLOOOO");
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = apiTestHelper.sendGetRequest(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
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

