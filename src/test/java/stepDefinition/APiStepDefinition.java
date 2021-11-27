/*
package stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class APiStepDefinition {

    Response response;
    JSONObject jsonObject;
    JSONArray jsonArray;
    HashMap<String,Integer> hmQuery = new HashMap<>();

//    @Given("set the base uri as {string}")
//    public void set_the_base_uri_as(String baseUri) {
//        RestAssured.useRelaxedHTTPSValidation();
//        RestAssured.baseURI = baseUri;
//    }
//
//    @Given("set request header {string} as {string}")
//    public void set_request_header_as(String headerName, String headerValue) {
//        RestAssured.given().header(headerName, headerValue);
//
//    }

    @Step("Triggered GET request")
    @Given("Submit GET request {string}")
    public void submit_get_request(String getRequestUri) {
        response = RestAssured.when().get(getRequestUri).then().extract().response();
    }

    @When("Extract the response body")
    public void extract_the_response_body() {
        response = RestAssured.when().get("").then().extract().response();

    }

    @Then("Validate response status code as {string}")
    public void validate_response_status_code_as(String responseCode) {
        System.out.println("response status code is:" + response.getStatusCode());
        Assert.assertEquals(Integer.parseInt(responseCode), response.getStatusCode());
    }

    @Then("Validate response body as {string} , {string} , {string}")
    public void validate_response_body_as(String employee_name, String employee_salary, String message) {
        System.out.println(response.asString());
        Assert.assertEquals(employee_name, response.jsonPath().getString("data.employee_name"));
        Assert.assertEquals(employee_salary, response.jsonPath().getString("data.employee_salary"));
        Assert.assertEquals(message, response.jsonPath().getString("message"));

    }

    //------------------------

    // Post request for adding employee details
    HashMap<String, String> hmBody = new HashMap<>();

    @Given("set request body {string} as {string}, {string} as {string},{string} as {string}")
    public void set_request_body_as_as_as(String keyOne, String keyValue, String keyTwo, String valueTwo, String keyThree, String valueThree) {

        hmBody.put(keyOne,keyValue);
        hmBody.put(keyTwo,valueTwo);
        hmBody.put(keyThree,valueThree);
        RestAssured.given().body(hmBody);
    }

    @Step("Triggered POST request")
    @Given("Submit POST request {string}")
    public void submit_post_request(String postUri) {
       response =RestAssured.when().post(postUri).then().extract().response();
    }

    @Step("Triggered PUT request")
    @Given("Submit PUT request {string}")
    public void submit_put_request(String putUri) {
      response = RestAssured.when().put(putUri).then().extract().response();
    }

    @Step("Triggered DELETE request")
    @Given("Submit DELETE request {string}")
    public void submit_delete_request(String deleteUri) {
      response = RestAssured.when().delete(deleteUri).then().extract().response();
    }
    @When("Extract response body")
    public void extract_response_body() {
     response.getBody().asString();
    }

    @Then("Validate response {string} field as {string}")
    public void validate_response_field_as(String attributeName, String responseBodyMsg) {
     // Assert.assertEquals(responseStatusCode, response.getStatusCode());
      Assert.assertEquals(responseBodyMsg,response.jsonPath().getString(attributeName));
    }

    // Get request with query parameter with google API

    @Given("set query params {string} as {string}")
    public void set_query_params_as(String queryKey, String queryValue) {
     RestAssured.given().queryParam(queryKey,Integer.parseInt(queryValue));
    }

    @Given("set query params {string} as {string},{string} as {string}")
    public void set_query_params_as_as(String queryKey, String queryValue, String queryKey1, String queryValue1) {
        hmQuery.put(queryKey,Integer.parseInt(queryValue));
        hmQuery.put(queryKey1,Integer.parseInt(queryValue1));
        RestAssured.given().queryParam(String.valueOf(hmQuery));

    }

    @Given("set query params for the request")
    public void set_query_params_for_the_request(io.cucumber.datatable.DataTable dataTable) {

        Map<String,String> queryMap = dataTable.asMap(String.class,String.class);
        RestAssured.given().queryParams(queryMap);
//        for(String key: queryMap.keySet()){
//            System.out.println("query values are:"+queryMap.get(key));
//            RestAssured.given().queryParam(key,Integer.parseInt(queryMap.get(key)));
//        }
    }

    @Then("Validate response body {string} as {string}")
    public void validate_response_body_as(String responseKey, String responseValue) {
       //Assert.assertEquals(responseValue,response.jsonPath().getString(responseKey));
        System.out.println("pokemon api response is:"+response.asString());
        responseKey = "results[0].name";
       Assert.assertEquals(responseValue, response.jsonPath().getString(responseKey));

    }
}
*/
