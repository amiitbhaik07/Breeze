package bddSteps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class GoogleSteps
{
	@Given("^I am on google homepage$")
	public void i_am_on_google_homepage() throws Throwable {
	    System.out.println("I am on first step");
	}

	@When("^I search for '(.*)'$")
	public void i_search_for(String s) throws Throwable {
		System.out.println("I am on second step");
		if(s.equalsIgnoreCase("tcs"))
		{
			throw new Exception("Sample exception");
		}
	}

	@When("^I open Images tab$")
	public void i_open_Images_tab() throws Throwable {
		System.out.println("I am on third_1 step");
	}
	
	@When("^I open News tab$")
	public void i_open_News_tab() throws Throwable {
		System.out.println("I am on third_2 step");
	}

	@Then("^I should see images displayed$")
	public void i_should_see_images_displayed() throws Throwable {
		System.out.println("I am on fourth step");
	}
	
	
	
	
	
}
