Feature: Get user profile details

  Background: Launch API Base URI
    Given set the base uri as "https://reqres.in/api"
    And set request header "Content-Type" as "application/json"


  Scenario Outline:
    Given Set requestBody of email as "<email>" and password as "<password>"
    When  Submit POST register request "/register"
    Then  validate response code as "200"
    Then validate POST response body id as "<id>"
    And  Submit GET All user request "/users" query param as "<page>"
    Then validate response code as "200"
    And Validate response firstname fields as "<name>"
    And Set request parameter of Update user userId as "<userId>"
    And Set request body of Update user name as "<name>" and job as "<job>"
    Then Submit update user request "/users"
    And validate response code as "200"
    And Set request parameter of Delete user userId as "<id>"
    Then Submit delete user request "/users"
    And validate response code as "204"
    Then Submit GET All user request "/users" query param as "<page>"
    And validate response name field value as "Eve"

    Examples:
      | email              | password | name| userId | page| id    |  job |
      | eve.holt@reqres.in | pistol   |Eve  |  2     | 2   |  4    |  leader |



