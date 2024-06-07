package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.steps.utils.ApiTestHelper;

import static org.hamcrest.CoreMatchers.equalTo;

public class ArtObjectSteps {

    private final CommonSteps commonSteps;

    public ArtObjectSteps(CommonSteps commonSteps) {
        this.commonSteps = commonSteps;
    }

    @When("I send a GET request to {string} with id {string} and imgonly {string}")
    public void i_send_a_get_request_with_optional_params(String endpoint, String id, String imgonly) {
        Response response = commonSteps.getApiTestHelper().sendGetRequestWithIdAndParam(endpoint, id, imgonly);
        commonSteps.setResponse(response);
    }

    @Then("the response should contain the title {string}")
    public void the_response_should_contain_the_title(String title) {
        commonSteps.getResponse().then().body("artObjects[0].title", equalTo(title));
    }
}
