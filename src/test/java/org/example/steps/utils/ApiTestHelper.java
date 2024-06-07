package org.example.steps.utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.config.LogConfig.logConfig;

public class ApiTestHelper {

    private String apiKey;

    public ApiTestHelper(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Response sendGetRequest(String endpoint) {
        return given()
                .config(config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .queryParam("key", apiKey)
                .log().all()
                .when()
                .get("https://www.rijksmuseum.nl" + endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response sendGetRequestWithParams(String endpoint, String query, String imgonly, String ps) {
        return given()
                .config(config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .queryParam("key", apiKey)
                .queryParam("q", query)
                .queryParam("imgonly", imgonly)
                .queryParam("ps", ps)
                .log().all()
                .when()
                .get("https://www.rijksmuseum.nl" + endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response sendGetRequestWithIdAndParam(String endpoint, String id, String imgonly) {
        return given()
                .config(config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .queryParam("key", apiKey)
                .queryParam("imgonly", imgonly)
                .log().all()
                .when()
                .get("https://www.rijksmuseum.nl" + endpoint + "/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
