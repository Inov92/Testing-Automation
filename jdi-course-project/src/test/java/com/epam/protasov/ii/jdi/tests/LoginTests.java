package com.epam.protasov.ii.jdi.tests;

import com.epam.web.matcher.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import  com.epam.jdi.course.dataProviders.UsersProvider;
import com.epam.jdi.course.entities.User;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.*;
import static com.epam.jdi.course.enums.Preconditions.LOGGED_IN;
import static com.epam.jdi.course.enums.Preconditions.LOGGED_OUT;

/**
 * Created by Ivan on 01.06.2017.
 */
public class LoginTests extends TestsBase{
    @BeforeMethod
    public void before(Method method) throws IOException {
        homePage.shouldBeOpened();
    }

    @Test(dataProvider = "users", dataProviderClass = UsersProvider.class)
    public void loginTest(User user) {
        isInState(LOGGED_OUT);
        homePage.login();
        Assert.isTrue(homePage.isLoggedIn());
    }
    @Test(dataProvider = "users", dataProviderClass = UsersProvider.class)
    public void logoutTest(User user) {
        isInState(LOGGED_IN);
        homePage.logout();
        Assert.isTrue(homePage.isLoggedOut());
    }

}
