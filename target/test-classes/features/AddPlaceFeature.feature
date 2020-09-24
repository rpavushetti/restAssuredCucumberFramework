Feature: Validating Place API's

Scenario Outline: Verify if place is being added successfully
Given Add place payload "<name>"  "<language>" "<address>"
When user calls "AddPlaceAPI" with http "POST" request
Then the API call is success with statuscode 200
And the "status" in response should say "OK"
And the "scope" in response should say "APP"
And verify place_id created maps to "<name>" using "getPlaceAPI"


Examples:
|name             |language  |   address         |
|Apr constructions|English   | Dattathreya layout|
#|Apr Builders     |English   | JP Nagar			 |