package com.tyco.restapi;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = { "pretty", "html:target/cucumber-html-report" }, features = {
		"src/main/java/com/tyco/resources/restapi.feature" } //dryRun = true
)
public class TestRunner {

}
