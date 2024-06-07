package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class CollectionSteps {

    private final CommonSteps commonSteps;

    public CollectionSteps(CommonSteps commonSteps){
        this.commonSteps = commonSteps;
    }

    @When("I send a GET request to {string} with query {string}, imgonly {string}, and ps {string}")
    public void i_send_a_get_request_with_optional_params(String endpoint, String query, String imgonly, String ps) {
        Response response = commonSteps.getApiTestHelper().sendGetRequestWithParams(endpoint, query, imgonly, ps);
        commonSteps.setResponse(response);
    }

    @Then("the response should contain artworks")
    public void the_response_should_contain_artworks() {
        commonSteps.getResponse().then().body("artObjects", not(empty()));
    }
}
