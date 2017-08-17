package com.ivan.protasov.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPanel{


    @FindBy(css = "div.profile-photo")
    public WebElement profileDropdown;

    @FindBy(id = "Login")
    public WebElement loginField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(className = "btn-login")
    public WebElement submitButton;

    @FindBy (css = ".profile-photo>span")
    public WebElement profileName;

    public LoginPanel(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
