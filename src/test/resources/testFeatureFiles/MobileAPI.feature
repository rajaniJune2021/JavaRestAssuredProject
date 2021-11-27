Feature:

  Background:Launch Base API Url
    Given set the base uri as "https://apisuat.calif.aaa.com/ebiz/uat2"


  Scenario Outline:Register User
#    Given Set POST request Body Of Register User email as "<email>" password as "<password>" memExpDate as "<memExpDate>" memNumber as "<memNumber>" and DOB as "<DOB>"
#    And set request header "X-IBM-Client-Id" as ""
#    And set request header "X-IBM-Client-Secret" as ""
#    And set request header "Content-Type" as "application/json"
#    When Submit POST Register user request "/account"
#    And  validate response code as "200"
    And Set POST request body Of Login Member username as "<username>" password as "<password>" clubCode as "<clubCode>"
    And set request header "X-IBM-Client-Id" as ""
    And set request header "X-IBM-Client-Secret" as ""
    And set request header "Content-Type" as "application/json"
    And Submit POST Login user request "/user/session"
    And validate response code as "200"
    And Validate response body accessToken as "e" customerId as "000000000000000"
#    And set request header "X-IBM-Client-Id" as ""
#    And set request header "X-IBM-Client-Secret" as ""
#    And set request accessToken header "Authorization"
#    And Set GET List of Policies parameter clubCode as "<clubCode>" customerId as "<customerId>"
    And Submit GET list of policies "/policies"
    And validate response code as "200"
    And validate response fields policyType as "Auto" policyNumber as "CAA"


    Examples:
      | email                     | password  | memExpDate | memNumber        | DOB        | username                  | password  | clubCode |
      | test@test.com | test | 2020-10-15 | 00000000000000 | 1900-10-28 | test@test.com | test | 004      |







