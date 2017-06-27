package com.epam.jdi.course.sites.jdiTestSite.sections;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 24.05.2017.
 */
public class Profile extends Section {
    @FindBy(css = ".uui-profile-menu")
    public Button loginDropdown;

    @FindBy(css = ".profile-photo>span")
    public Label profileName;

    //To DO сделать, чтобы возвращало true или false. equals innerHTML = "hidden"
    public void isLogin(){
        profileName.isDisplayed();
        Assert.isNotEmpty(profileName.getText());
    }

}
