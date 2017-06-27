package com.epam.jdi.course.sites.jdiTestSite.sections;

import com.epam.jdi.course.entities.User;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 26.05.2017.
 */
public class LoginPanel extends Form<User> {
    @FindBy(id = "Login")
    public TextField loginField;

    @FindBy(id = "Password")
    public TextField password;

    @FindBy(css = ".btn-login")
    public Button login;
    @FindBy(xpath = "//span[.='Logout']")
    public Button logout;



}
