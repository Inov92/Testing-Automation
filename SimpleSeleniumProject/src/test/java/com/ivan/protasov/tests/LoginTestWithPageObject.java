package com.ivan.protasov.tests;

import com.ivan.protasov.pageobjects.LoginPanel;
import org.junit.Assert;
import org.junit.Test;

public class LoginTestWithPageObject extends TestsBase{

    @Test
    public void loginTest(){
        LoginPanel loginPanel = new LoginPanel(driver);
        loginPanel.profileDropdown.click();
        loginPanel.loginField.sendKeys("epam");
        loginPanel.passwordField.sendKeys("1234");
        loginPanel.submitButton.click();
        Assert.assertEquals("PITER CHAILOVSKII",loginPanel.profileName.getText());
    }

}
