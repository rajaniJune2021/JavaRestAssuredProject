package stepDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class userStepDefinition {
   public static RequestSpecification requestSpecification;
    public static Response response;
    List<String> responseFirstNameLists;
    HashMap<String, String> hashMap = new HashMap<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @Given("set the base uri as {string}")
    public void set_the_base_uri_as(String baseUri) {
        //  RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = baseUri;
        requestSpecification = RestAssured.given();
    }

    @Given("set request header {string} as {string}")
    public void set_request_header_as(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);

    }

    @Given("Set requestBody of email as {string} and password as {string}")
    public void set_request_body_of_email_as_and_password_as(String email, String password) throws JsonProcessingException {
//        hashMap.put("password", password);
//        hashMap.put("email", email);
//        String requestJson = objectMapper.writeValueAsString(hashMap);
          RegisterClass registerClass = new RegisterClass(password,email);
          requestSpecification.given().body(registerClass);

    }

    @When("Submit POST register request {string}")
    public void submit_post_register_request(String postRegisterUri) throws JsonProcessingException {

        response = requestSpecification.post(postRegisterUri).then().extract().response();
        System.out.println("post response is:" + response.asString());
        System.out.println();
    }

    @Then("validate response code as {string}")
    public void validate_response_code_as(String statusCode) {
        System.out.println(response.asString());
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }

    @Then("validate POST response body id as {string}")
    public void validate_post_response_body_id_as(String id) {
       RegisterClass registerUser =  response.as(RegisterClass.class);
       Assert.assertEquals(Integer.parseInt(id), registerUser.getId());
    }

    @Then("Submit GET All user request {string} query param as {string}")
    public void submit_get_all_user_request_query_param_as(String getAllUsers, String page) {
        response = RestAssured.given().queryParam(page).when().get(getAllUsers).then().extract().response();
        System.out.println("get all users response" + response.asString());
    }

    @Then("Validate response firstname fields as {string}")
    public void validate_response_firstname_fields_as(String firstName) throws JsonProcessingException {
        boolean b = false;
        //responseFirstNameLists = response.getBody().jsonPath().getList("data.first_name");
        Example getAllUsersClass = response.as(Example.class);
        System.out.println(getAllUsersClass.getData().get(2).getFirstName());
//        System.out.println("first name list is:" + responseFirstNameLists);
//        for (String s : responseFirstNameLists) {
//            if (s.equalsIgnoreCase(firstName)) {
//                b = true;
//            }
//        }
//        Assert.assertTrue(b, "User name matches of values from the list");
    }

    @Then("Set request body of Update user name as {string} and job as {string}")
    public void set_request_body_of_update_user_name_as_and_job_as(String name, String job) throws JsonProcessingException {
//        hashMap.put("name", name);
//        hashMap.put("job", job);
//        String json = objectMapper.writeValueAsString(hashMap);
//        requestSpecification = RestAssured.given().body(json);
        UpdateUser updateUser =  new UpdateUser(name,job);
        requestSpecification.given().body(updateUser);
    }

    @Then("Set request parameter of Update user userId as {string}")
    public void set_request_parameter_of_update_user_user_id_as(String id) {
        requestSpecification.when().param(id);
    }

    @Then("Submit update user request {string}")
    public void submit_update_user_request(String putUserURi) {
        response = requestSpecification.put(putUserURi).then().extract().response();
        System.out.println("update user request response" + response.asString());
    }

    @Then("Set request uri parameter name as {string} and id as {string}")
    public void set_request_uri_parameter_name_as_and_id_as(String name, String id) {
        requestSpecification = RestAssured.given().pathParam(name, id);
    }

    @Given("Set request parameter of Delete user userId as {string}")
    public void set_request_parameter_of_delete_user_user_id_as(String id) {
        requestSpecification.when().param(id);
    }

    @Then("Submit delete user request {string}")
    public void submit_delete_user_request(String deleteUri) {
        //response = RestAssured.given().when().delete(deleteUri).then().extract().response();
        response = requestSpecification.when().delete(deleteUri).then().extract().response();
        System.out.println("Delete request response code" + response.getStatusCode());
        System.out.println("Delete user request response " + response.asString());
    }

    @Then("validate response name field value as {string}")
    public void validate_response_name_field_value_as(String nameValueAfterDelete) {
        List<String> nameValue = response.getBody().jsonPath().getList("data.first_name");
        if (nameValue.contains(nameValueAfterDelete)) {
            Assert.assertTrue(false, "after deletion data still exist");

        }
    }
}

