package org.protasov.ii.lesson4;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.*;
public class testLesson4 {

    WebDriver driver;
    Actions type;
    @BeforeTest
    public void beforeTest(){
        TestSettings settings = new TestSettings();
        System.setProperty(settings.getDriverName(), settings.getDriverPath());
        driver = new FirefoxDriver(); //for FireFox browser
        type = new Actions(driver);
        System.out.println("WebDriverCreated");
    }

    @Test
    public void test1(){
        System.out.println("First test started");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
        System.out.println("WebDriverClosed");
    }

}
