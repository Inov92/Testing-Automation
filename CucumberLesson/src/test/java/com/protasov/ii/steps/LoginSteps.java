package com.protasov.ii.steps;

import com.protasov.ii.pageobjects.LoginPanel;
import com.protasov.ii.testbase.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

/**
 * Created by Ivan on 08.06.2017.
 */
public class LoginSteps extends BaseTest {

    @Given("^I am on home page$")
    public void open(){

        Reporter.log("=====Browser Session Started=====", true);
        TestSettings settings = new TestSettings();
        System.setProperty(settings.getDriverName(), settings.getDriverPath());
        driver = new FirefoxDriver();
        Reporter.log("=====WebDriver created=====", true);
        loadPage("https://jdi-framework.github.io/tests/index.htm");
    }
    @When("^I login as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginValidUsers(String login, String password){
        System.out.println("loginValid");
        LoginPanel.init().
                openLoginPanel().
                registerUser(login,password).
                pressEnterToLogin();
    }
    @Then("^Profile name is visible$")
    public void checkProfile(){
        //System.out.println(LoginPanel.init().isProfileNameVisible());
        System.out.println("Then");
        Assert.assertTrue(LoginPanel.init().isProfileNameVisible());
    }

    @When("^I login as wrong users from csv$")
    public void loginInvalidUsers(){
        System.out.println("Wrong User");
        LoginPanel.init().
                openLoginPanel().
                registerUser("Ivan","311292").
                pressEnterToLogin();
    }

    @Then("^Failed message is visible$")
    public void failedMessageIsVisible() {
        //Assert.assertTrue(LoginPanel.init().isLoginFailureMessageVisible());
        System.out.println("Failed message");
    }
    @Then("^close browser$")
    public void closeBrowser(){ driver.close();}

//    @After
//    public void closeDriver(){
//        System.out.println("After");
//        driver.close();
//        Reporter.log("=====WebDriver closed=====", true);
//
//    }


}
