package com.epam.protasov.ii.jdi.tests;

import com.epam.jdi.course.enums.Preconditions;
import com.epam.jdi.course.sites.jdiTestSite.JdiTestSite;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils.killAllRunWebBrowsers;

/**
 * Created by Ivan on 24.05.2017.
 */
public abstract class TestsBase extends TestNGBase {
    public static Preconditions precondition;
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JdiTestSite.class);

        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() throws IOException {
        killAllRunWebBrowsers();
    }
}
