Feature:API service request tests

  Background: Launch API Base URI
  //  Given set the base uri as "http://dummy.restapiexample.com/api/v1"
   // Given set the base uri as "https://www.google.com"
    Given set the base uri as "https://pokeapi.co"
    And set request header "Content-Type" as "application/json"

#  Scenario:
#    Given Enter post request header
#    And Enter post request body
#    When send request endPoint
#    Then Extract response body
#    And Validate request status code
#
#

  Scenario:Get customer details
    Given set request header "" as ""
    And Submit GET request "/employees"
    Then Validate response status code as "200"


  Scenario:Get employee details
    And Submit GET request "/employee/1"
    Then Validate response body as "Tiger Nixon" , "320800" , "Successfully! Record has been fetched."
    Then Validate response status code as "200"

  @smokeTest
  Scenario:Add customer details
    And   set request body "name" as "testfgc130", "salary" as "12897345","age" as "27"
    And   Submit POST request "/create"
    Then Validate response status code as "200"
    And Validate response "message" field as "Successfully! Record has been added."

  Scenario:Update customer details
    And  set request body "name" as "testfgc1267", "salary" as "1289734","age" as "28"
    And Submit PUT request "/update/28"
    Then Validate response status code as "200"
    And Validate response "message" field as "Successfully! Record has been updated."

  Scenario: DELETE customer details
    And Submit DELETE request "/delete/7"
    Then Validate response status code as "200"
    And Validate response "message" field as "Successfully! Record has been deleted"

    Scenario:GET qa automation details
      And set query params "q" as "automation+testing"
      And Submit GET request "/search"
      Then Validate response status code as "200"

    Scenario:GET PokeMan characters details
      And set query params for the request
      |limit| 7|
      |offset| 24|
      And Submit GET request "/api/v2/pokemon/"
      Then Validate response status code as "200"
      Then Validate response body "name" as "bulbasaur"










