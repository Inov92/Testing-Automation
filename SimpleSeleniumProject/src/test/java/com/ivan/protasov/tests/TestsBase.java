package com.ivan.protasov.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestsBase {

    WebDriver driver;
    DesiredCapabilities capabilities;
    WebDriverWait wait;
    @Before
    public void setUp(){
        capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName("Chrome");

        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver(capabilities);
        wait = new WebDriverWait(driver,10);

        driver.manage().window().maximize();

        //Global timeouts which called before every findElement
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
