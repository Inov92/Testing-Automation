package com.epam.protasov.ii.jdi.tests;

import com.epam.jdi.course.entities.User;
import com.epam.jdi.course.sites.jdiTestSite.JdiTestSite;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.homePage;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.contactPage;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.course.enums.Preconditions.LOGGED_IN;

import java.io.IOException;
import java.lang.reflect.Method;

import  com.epam.jdi.course.dataProviders.UsersProvider;


/**
 * Created by Ivan on 24.05.2017.
 */
public class FormTests extends TestsBase {
    @BeforeMethod
    public void before(Method method) throws IOException {
        homePage.shouldBeOpened();
        isInState(LOGGED_IN);
        JdiTestSite.headerMenu.clickOn("CONTACT FORM");
        contactPage.checkOpened();
    }

    @Test(dataProvider = "users", dataProviderClass = UsersProvider.class)
    public void loginTest(User user){
        contactPage.contactForm.submit(user);
        Assert.assertEquals(contactPage.resultSection.get(1).getText(), "Name: " + user.name);
        Assert.assertEquals(contactPage.resultSection.get(2).getText(), "Last Name: " + user.lastName);
        Assert.assertEquals(contactPage.resultSection.get(3).getText(), "Description: " + user.description);

    }
}
