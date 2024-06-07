package org.example.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

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
        Response response = commonSteps.getResponse();
        String actualTitle = response.path("artObject.title");
        assertThat(actualTitle).
                isNotNull().
                as("Checking title").
                isEqualTo(title);

    }
}
