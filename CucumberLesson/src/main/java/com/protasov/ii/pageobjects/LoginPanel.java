package com.protasov.ii.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.protasov.ii.testbase.BaseTest;

public final class LoginPanel extends BaseTest{

    private static volatile LoginPanel _instance = null;
    private WebDriverWait wait;

    //TO DO множественаая иинициал
    private LoginPanel(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public static synchronized LoginPanel init() {
        if (_instance == null)
            synchronized (LoginPanel.class) {
                if (_instance == null)
                    _instance = new LoginPanel(driver);
            }
        return _instance;
    }

    //Активировать панель
    @FindBy(css = "div.profile-photo")
    private WebElement profile;
    //Текст Login
    //Текст Password

    //Поле ввода логин
    @FindBy(id = "Login")
    private  WebElement loginField;

    //Поле ввода пароль
    @FindBy(id = "Password")
    private WebElement passwordField;

    //Кнопка Enter
    @FindBy(xpath = "//span[.='Enter']")
    private WebElement enterButton;

    //Имя залогинившегося пользователся
    @FindBy(css = ".profile-photo>span")
    private WebElement  profileName;

    //Кнопка logout
    //Надпись LoginFailed
    @FindBy(className = "login-txt")
    private WebElement failureMessage;

    public synchronized WebElement getFailureMessage() {
        return failureMessage;
    }

    public synchronized LoginPanel openLoginPanel(){
        profile.click();
        return this;
    }
    public synchronized  LoginPanel registerUser(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        return this;
    }
    public synchronized LoginPanel pressEnterToLogin(){
        enterButton.click();
        return this;
    }

    public synchronized boolean isProfileNameVisible(){
        //return false;

        //return profileName.getCssValue("visibility").equals("visible");
        return  profileName.isDisplayed();
        //profileName.click();
//        System.out.println(profileName.getCssValue("outerHTML"));
//        return true ;
    }

    public synchronized boolean isLoginFailureMessageVisible(){
        return failureMessage.getCssValue("visibility").equals("visible");
    }

    public synchronized String getFailureMessageText(){
        return failureMessage.getAttribute("innerHTML");
    }



}
