package com.ivan.protasov.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SimpleLoginTest extends TestsBase {
    @Test
    public void loginTest(){
        WebElement profileDropdown = driver.findElement(By.cssSelector("div.profile-photo"));
        profileDropdown.click();

        WebElement loginField = driver.findElement(By.id("Login"));
        loginField.sendKeys("epam");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("1234");

        WebElement submitButton = driver.findElement(By.className("btn-login"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        WebElement profileName = driver.findElement(By.cssSelector(".profile-photo>span"));
        Assert.assertEquals("PITER CHAILOVSKII", profileName.getText());
    }
}
