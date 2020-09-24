package stepDefinitions;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Resources;
import resources.TestDataBuild;
import resources.Utils;


public class StepDefinition extends Utils{
	RequestSpecification res;
	ResponseSpecification postRes;
	Response response;
	TestDataBuild data = new TestDataBuild();
	String place_id;
	

@Given("Add place payload {string}  {string} {string}")
public void add_place_payload(String name, String language, String address) throws Throwable {

    	 	
    	postRes = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    	
    	 res=given().spec(requestSpecifiction())
    	.body(data.addPlacePayLoad(name, language, address));
        
    }

    @When("user calls {string} with http {string} request")
    public void user_calls_addplaceapi_with_http_request(String resource, String method) throws Throwable {
    	Resources resourceAPI = Resources.valueOf(resource);
    	   	
    	if(method.equalsIgnoreCase("POST"))
    	response = res.when().post(resourceAPI.getResource());
    	else if(method.equalsIgnoreCase("GET"))
    		response = res.when().get(resourceAPI.getResource());
    			System.out.println(response);
    			
        
    }

    @Then("the API call is success with statuscode 200")
    public void the_api_call_is_success_with_statuscode_200() throws Throwable {
    	assertEquals(response.getStatusCode(),200);
    	
        
    }

    @Then("the {string} in response should say {string}")
    public void the_status_in_response_should_say_ok(String keyValue, String ExpectedValue) throws Throwable {
    	
    	assertEquals(getJsonPath(response, keyValue).toString(),ExpectedValue);
    	
    }
    @Then("verify place_id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using_get_place_api(String expectedName,String resource) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	String place_id = getJsonPath(response, "place_id");
       res=given().spec(requestSpecifiction()).queryParam("place_id", place_id);
       user_calls_addplaceapi_with_http_request(resource, "GET");
       String actual_name = getJsonPath(response, "name");
      assertEquals(expectedName,actual_name);
    }

}