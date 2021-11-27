Feature:

  Background:Launch Base API Url
    Given set the base uri as "https://apisuat.calif.aaa.com/ebiz/uat2"


  Scenario Outline:Register User
#    Given Set POST request Body Of Register User email as "<email>" password as "<password>" memExpDate as "<memExpDate>" memNumber as "<memNumber>" and DOB as "<DOB>"
#    And set request header "X-IBM-Client-Id" as "832512b7-ca21-4ea5-a3dd-ab53a2ce7ca2"
#    And set request header "X-IBM-Client-Secret" as "jB8oN2hF3wQ0jD8cY0cD7kA8cW4dY4tH7dH8bB0eU5nO1jJ1lQ"
#    And set request header "Content-Type" as "application/json"
#    When Submit POST Register user request "/account"
#    And  validate response code as "200"
    And Set POST request body Of Login Member username as "<username>" password as "<password>" clubCode as "<clubCode>"
    And set request header "X-IBM-Client-Id" as "832512b7-ca21-4ea5-a3dd-ab53a2ce7ca2"
    And set request header "X-IBM-Client-Secret" as "jB8oN2hF3wQ0jD8cY0cD7kA8cW4dY4tH7dH8bB0eU5nO1jJ1lQ"
    And set request header "Content-Type" as "application/json"
    And Submit POST Login user request "/user/session"
    And validate response code as "200"
    And Validate response body accessToken as "e" customerId as "000000000000000"
#    And set request header "X-IBM-Client-Id" as "832512b7-ca21-4ea5-a3dd-ab53a2ce7ca2"
#    And set request header "X-IBM-Client-Secret" as "jB8oN2hF3wQ0jD8cY0cD7kA8cW4dY4tH7dH8bB0eU5nO1jJ1lQ"
#    And set request accessToken header "Authorization"
#    And Set GET List of Policies parameter clubCode as "<clubCode>" customerId as "<customerId>"
    And Submit GET list of policies "/policies"
    And validate response code as "200"
    And validate response fields policyType as "Auto" policyNumber as "CAA"


    Examples:
      | email                     | password  | memExpDate | memNumber        | DOB        | username                  | password  | clubCode |
      | sonico.kris@aaa-calif.com | autoclub1 | 2020-10-15 | 6200041275393303 | 1978-10-27 | sonico.kris@aaa-calif.com | autoclub1 | 004      |







