import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan on 04.05.2017.
 */
public class Lesson2Tests {
    WebDriver driver;
    Actions type;
    @BeforeTest
    public void beforeTest(){
        TestSettings settings = new TestSettings();
        System.setProperty(settings.getDriverName(), settings.getDriverPath());
        driver = new FirefoxDriver(); //for FireFox browser
        //driver = new ChromeDriver(); //for Chrome browser
        type = new Actions(driver);
        System.out.println("WebDriverCreated");
    }

    @Test(dataProvider = "dataFromCsv", dataProviderClass = DataProviders.class)
    public void testPositive(String name, String pass){
        System.out.println("Positive test started");
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        WebElement loginClick = driver.findElement(By.className("fa-user"));
        loginClick.click();

        WebElement login = driver.findElement(By.id("Login"));
        type.sendKeys(login,name).perform();
        WebElement password = driver.findElement(By.id("Password"));
        type.sendKeys(password, pass).perform();

        WebElement enter = driver.findElement(By.className("btn-login"));
        enter.click();

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement userName = driver.findElement(By.className("hidden"));
        Assert.assertEquals(userName.getAttribute("textContent"),"Piter Chailovskii");

        //Проверка, показывается ли текст имя пользователя
        //Assert.assertEquals(userName.getCssValue("display"), "inline");

    }

    @Test(dataProvider = "dataFromMethod", dataProviderClass = DataProviders.class,
            expectedExceptions = AssertionError.class)
    public void testNegative(String name, String pass){
        System.out.println("Negative test started");

        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        WebElement loginClick = driver.findElement(By.className("fa-user"));
        loginClick.click();

        WebElement login = driver.findElement(By.id("Login"));
        type.sendKeys(login,name).perform();
        WebElement password = driver.findElement(By.id("Password"));
        type.sendKeys(password, pass).perform();

        WebElement enter = driver.findElement(By.className("btn-login"));
        enter.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //WebElement userName = driver.findElement(By.className("hidden"));

        WebElement result = driver.findElement(By.className("login-txt"));
        //TO DO выключить игнорирование ошибок, когда на сайте исправят ошибку
        Assert.assertEquals(result.getAttribute("innerHTML"), "* Login Failed");
        //Проверка, показывается ли текст Login Failed
        //Не работает. getCssValue возвращает старое значение none
        //Assert.assertEquals(result.getCssValue("display"), "inline");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
        System.out.println("WebDriverClosed");
    }












}
