package com.tyco.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.*;

public class RestApiTestSteps {

	final Logger logger = LoggerFactory.getLogger(RestApiTestSteps.class);

	@Given("^I request the endpoint \"([^\"]*)\"$")
	public void I_request_the_endpoint(String url) {
		RestApiActions.requestEndPointForGET(url);
	}
	
	@Given("^I request the post endpoint \"([^\"]*)\":$")
	public void I_request_the_post_endpoint_(String restURL, String jsonPayload){
	    RestApiActions.requestEndPointForPOST(restURL, jsonPayload);
	}
	
	@Given("^I request the post endpoint \"([^\"]*)\"$")
	public void I_request_the_post_endpoint(String restURL, String jsonPayload) {
		RestApiActions.requestEndPointForPOST(restURL, jsonPayload);
	}

	@Then("^I check the status code \"([^\"]*)\"$")
	public void I_check_the_status_code(int statusCode) {
		RestApiActions.testStatusCode(statusCode);
	}

	@Then("^I check the response contant type \"([^\"]*)\"$")
	public void I_check_the_response_contant_type(String contantType) {
		RestApiActions.testMimeType(contantType);
	}

	@Then("^I check the response contant with \"([^\"]*)\" \"([^\"]*)\"$")
	public void I_check_the_response_contant_with(String element, String contant) {
		RestApiActions.testContentJSON(element, contant);
	}
}