package com.epam.jdi.course.sites.jdiTestSite.pages;

import com.epam.jdi.course.entities.User;
import com.epam.jdi.course.sites.jdiTestSite.JdiTestSite;
import com.epam.jdi.course.sites.jdiTestSite.sections.LoginPanel;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.homePage;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.profile;

/**
 * Created by Ivan on 24.05.2017.
 */
public class HomePage extends WebPage {

    @FindBy(css = ".dropdown-menu-login")
    public LoginPanel loginPanel;


    public boolean isLoggedIn(){
        System.out.println("isLoggedIn() return " + profile.profileName.isDisplayed());
        return profile.profileName.isDisplayed();
    }

    public boolean isLoggedOut(){
        System.out.println("isLoggedOut() return " + profile.profileName.isHidden());
        return profile.profileName.isHidden();
    }

    public void login(){
        login(new User());
    }
    public void login(User user) {
        homePage.shouldBeOpened();
        if(loginPanel.isHidden()) {
            profile.loginDropdown.click();
        }
        //JdiTestSite.logo.click(); // для того, чтобы убедиться, что форма логин закрыта
        homePage.loginPanel.isDisplayed();
        homePage.loginPanel.login(user);
    }
    public void logout() {
        if(!loginPanel.logout.isDisplayed())
            profile.profileName.click();
        loginPanel.logout.click();
        System.out.println("User was logged out");
    }
}
