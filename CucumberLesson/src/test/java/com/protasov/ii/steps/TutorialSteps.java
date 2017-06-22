package com.protasov.ii.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by Ivan on 08.06.2017.
 */
public class TutorialSteps {
    WebDriver driver = null;

    @Given("^I have open the browser$")
    public void openBrowser() {
//        System.setProperty("webdriver.gecko.driver", "C:\\Selenium-Drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
        System.out.println("Given");
    }

    @When("^I open Facebook website$")
    public void goToFacebook() {
        System.out.println("When");
    }

    @Then("^Login button should exits$")
    public void loginButton() {
//        if(driver.findElement(By.id("u_0_v")).isEnabled()) {
//            System.out.println("Test 1 Pass");
//        } else {
//            System.out.println("Test 1 Fail");
//        }
//        driver.close();
        System.out.println("Then");
    }
}
