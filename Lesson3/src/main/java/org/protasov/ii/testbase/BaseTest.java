package org.protasov.ii.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    protected void getFireFoxWebDriver(){
        Reporter.log("=====Browser Session Started=====", true);
        TestSettings settings = new TestSettings();
        System.setProperty(settings.getDriverName(), settings.getDriverPath());
        //System.setProperty("webdriver.gecko.driver", "C:\\Selenium-Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        Reporter.log("=====WebDriver created=====", true);
    }

    @AfterSuite(alwaysRun = true)
    protected void closeDriver(){
        driver.close();
        Reporter.log("=====WebDriver closed=====", true);
    }

    protected void navigateTo(String url){
        driver.navigate().to(url);
    }
}
