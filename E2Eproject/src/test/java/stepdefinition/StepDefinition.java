package stepdefinition;




import org.junit.runner.RunWith;

import org.testng.Assert;

import pageobject.LandingPage;
import pageobject.LoggedinPage;
import pageobject.LoginPage;
import resource.Base;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

	 @Given("^intialization of browser with chrome$")
	    public void intialization_of_browser_with_chrome() throws Throwable {
	        drive=intDrive();
	    }


	    @When("^enter the (.+) and (.+) and click on login$")
	    public void enter_the_and_and_click_on_login(String username, String password) throws Throwable {
	    	LoginPage lo = new LoginPage(drive);
		    lo.emailAdd().sendKeys(username);
		    lo.pass().sendKeys(password);
		    lo.lb().click();
	    }

	    @Then("^verify if the user has successfully logged in$")
	    public void verify_if_the_user_has_successfully_logged_in() throws Throwable {
	        LoggedinPage li = new LoggedinPage(drive);
	        Assert.assertTrue(li.searchQuery().isDisplayed());
	    }

	    @And("^navigate to \"([^\"]*)\" website$")
	    public void navigate_to_something_website(String strArg1) throws Throwable {
	        drive.get(strArg1);
	        drive.manage().window().maximize();
	    }

	    @And("^click on login link and navigate to login page$")
	    public void click_on_login_link_and_navigate_to_login_page() throws Throwable {
	    	LandingPage lp = new LandingPage(drive);
			if(lp.popupdisplayed().size()>0){
				lp.popuphandle().click();
			}
		    lp.loginselect().click();
	    }
	    
	    @And("^close the browsers$")
	    public void close_the_browsers() throws Throwable {
	        drive.quit();
	    }


}