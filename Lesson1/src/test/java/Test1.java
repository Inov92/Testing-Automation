import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan on 27.04.2017.
 */
public class Test1 {
    public WebDriver driver;
    FileInputStream fis;
    Properties property = new Properties();
    @Test
    /**
     * Test scenario: Open web site "https://epam.com".
     * Check web page title
     */
    public void exampleTest(){
        System.out.println("Test 1");
        System.setProperty("webdriver.gecko.driver", getGeckoDriverPath());
        driver = new FirefoxDriver();
        driver.navigate().to("https://epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        System.out.printf("Title test completed");
        driver.close();
    }
    @Test
    /**
     * Test scenario: Open web site "https://epam.com" on android device.
     * Check switching to contact page
     */
    public void capabiltiesTest(){
        System.out.println("Test 2");
        System.setProperty("webdriver.gecko.driver", getGeckoDriverPath());

        DesiredCapabilities settings = new DesiredCapabilities();
        settings.setBrowserName("firefox");
        settings.setPlatform(Platform.ANDROID);
        driver = new FirefoxDriver(settings);
        driver.manage().window().setSize(new Dimension(720, 1280));
        driver.navigate().to("https://epam.com");

        WebElement popup_Trigger = driver.findElement(By.className("popup-trigger"));
        popup_Trigger.click();
        WebElement contact_button = driver.findElement(By.linkText("Contact"));
        Actions action = new Actions(driver);
        action.moveToElement(contact_button).click().perform();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //ожидание загрузки страницы
        //TO DO Снять комментраий с Assert
        //Assert.assertEquals(driver.getCurrentUrl(),"https://www.epam.com/contact#russia");
        driver.close();
    }

    @Test
    /**
     * Load Avito page, check Samsung A5 offers
     */
    public void avitoTest() throws Exception {
        System.out.println("Test 3");
        System.setProperty("webdriver.gecko.driver", getGeckoDriverPath());
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.avito.ru/sankt-peterburg");

        WebElement search = driver.findElement(By.id("search"));
        Actions type_order = new Actions(driver);
        type_order.sendKeys(search, "Samsung A5").perform();

        //TO DO try to start searching by enter key
        //type_order.keyDown(Keys.ENTER).perform(); //do not working

        WebElement find = driver.findElement(By.className("search-form__submit"));
        find.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//do not working

        makePrtSc();

        //TO DO Снять комментраий с Assert
        //Assert.assertEquals(driver.getCurrentUrl(), "https://www.avito.ru/sankt-peterburg?q=Samsung+A5");

        //WebElement result = driver.findElement(By.className("nulus"));
        //Assert.assertFalse(result.isDisplayed());
        driver.close();

    }

    public void makePrtSc() throws IOException {
        System.out.println("Making screenshot of exception...");
        TakesScreenshot sc = (TakesScreenshot)driver;
        File screensFile = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screensFile, new File("./src/main/resources/fail.png"));
    }

    public String getGeckoDriverPath(){
        String path = "";
        try {
            fis = new FileInputStream("./src/main/resources/config.properties");
            property.load(fis);
            path = property.getProperty("geckodriverPath");

        } catch (IOException e) {
            System.err.println("ERROR: config.properties file not found!\n" +
                    "Locate config.properties in ./src/main/resources catalog");
        }
        return  path;

    }
}
