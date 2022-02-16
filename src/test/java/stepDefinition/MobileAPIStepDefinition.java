package stepDefinition;

import Request.CreateMemberShip;
import Request.LoginMembershipRequestBody;
import Response.GetListOfPolicies.ListOfPolicies;
import Response.LoginMembership.LoginMembership;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.collections.map.HashedMap;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class MobileAPIStepDefinition {

    RequestSpecification requestSpecification;
    Map<String, String> map = new HashedMap();
    String accessToken;
    String autoPolicyNumber;
    String customerId;
    SoftAssert softAssert = new SoftAssert();
    Response response1;


    @Given("Launch POST Mobile base URI as {string}")
    public void launch_post_mobile_base_uri_as(String url) {
        requestSpecification = RestAssured.given().body(url);
    }

    @Given("Set POST request body clientId {string} and secretID {string}")
    public void set_post_request_body_client_id_and_secret_id(String clientId, String clientSecret) {
        userStepDefinition.requestSpecification.headers(map);
    }

    @Given("Set POST request Body Of Register User email as {string} password as {string} memExpDate as {string} memNumber as {string} and DOB as {string}")
    public void set_post_request_body_of_register_user_email_as_password_as_mem_exp_date_as_mem_number_as_and_dob_as(String emailAddress, String password, String membershipExpDate, String membershipNumber, String dateOfBirth) {
        CreateMemberShip createMemberShip = new CreateMemberShip(emailAddress, password, membershipExpDate, membershipNumber, dateOfBirth);
        userStepDefinition.requestSpecification.given().body(createMemberShip);
    }


    @Given("Set POST request body Of Login Member username as {string} password as {string} clubCode as {string}")
    public void set_post_request_body_of_login_member_username_as_password_as_club_code_as(String userName, String password, String clubCode) {
        LoginMembershipRequestBody loginMembershipRequestBody = new LoginMembershipRequestBody(userName, password, clubCode);
        userStepDefinition.requestSpecification = RestAssured.given().body(loginMembershipRequestBody);
    }

    @Given("Submit POST Login user request {string}")
    public void submit_post_login_user_request(String login) {
        userStepDefinition.response = userStepDefinition.requestSpecification.given().when().post(login);
        System.out.println("response code is:" + userStepDefinition.response.statusCode());
        System.out.println("response is:" + userStepDefinition.response.asString());
    }

    @When("Submit POST Register user request {string}")
    public void submit_post_register_user_request(String register) {
        userStepDefinition.response = userStepDefinition.requestSpecification.given().when().post(register);
        System.out.println("response code is:" + userStepDefinition.response.statusCode());
        System.out.println("response is:" + userStepDefinition.response.asString());
    }

    @Given("Validate response body accessToken as {string} customerId as {string}")
    public void validate_response_body_access_token_as_customer_id_as(String authorizationToken, String custId) {
        LoginMembership loginMembership = userStepDefinition.response.as(LoginMembership.class);
        accessToken = loginMembership.getAccessToken();
        System.out.println("This is accessToken value" + accessToken);
        customerId = loginMembership.getCustomerId();
        System.out.println("login response custID " + customerId);
        userStepDefinition.requestSpecification = null;
        userStepDefinition.response = null;
//        if (authorizationToken.substring(0).equalsIgnoreCase(accessToken)) {
//            Assert.assertTrue(true);
//            loginMembership.getAccessToken();
//        } else {
//            Assert.assertTrue(false);
//            System.out.println("Access token not started with letter e ");
//        }
    }
    @Given("set request accessToken header {string}")
    public void set_request_access_token_header(String authorizationHeader) {
         userStepDefinition.requestSpecification.given().header(authorizationHeader,"Bearer "+accessToken);
    }

//    @Given("Set GET List of Policies parameter clubCode as {string} customerId as {string}")
//    public void set_get_list_of_policies_parameter_club_code_as_customer_id_as(String clubCode, String custId) {
//        map.put("clubCode", clubCode);
//        map.put("customerId", customerId );
//        System.out.println(map);
//        userStepDefinition.requestSpecification.given().queryParams(map);
//    }

    @Given("Submit GET list of policies {string}")
    public void submit_get_list_of_policies(String getUrl) {
        userStepDefinition.requestSpecification = RestAssured.given();
        map.put("clubCode", "004");
        map.put("customerId", customerId );
        System.out.println(map);
        System.out.println("accessToken value after resetting to null  " + accessToken);
      userStepDefinition.response = userStepDefinition.requestSpecification.given().header("X-IBM-Client-Id","testvalue").header("X-IBM-Client-Secret","testvalue").header("authorizationHeader","Bearer "+accessToken).queryParams(map).get(getUrl).then().extract().response();
        System.out.println("get policies response code " + userStepDefinition.response.statusCode());
//      userStepDefinition.response = userStepDefinition.requestSpecification.given().get(getUrl);
        System.out.println("get list of policies response" + userStepDefinition.response.asString());
    }

    @Given("validate response fields policyType as {string} policyNumber as {string}")
    public void validate_response_fields_policy_type_as_policy_number_as(String policyType, String policyNumber) {
        System.out.println("get list of policies response  "+userStepDefinition.response.asString());
        System.out.println(userStepDefinition.response.statusCode());
     ListOfPolicies listOfPolicies = userStepDefinition.response.as(ListOfPolicies.class);
       String autoPolicyType = listOfPolicies.getInsurancePolicyList().get(1).getPolicyType().substring(0);
        autoPolicyNumber = listOfPolicies.getInsurancePolicyList().get(1).getPolicyNumber().substring(0);
          if(autoPolicyType.contains(policyType)){
              softAssert.assertTrue(true);
          }else {
              softAssert.assertTrue(false);
          }
          if(autoPolicyNumber.contains(policyNumber)){
              softAssert.assertTrue(true);
          }else{
              softAssert.assertTrue(false);
          }
          softAssert.assertAll();
    }

}
