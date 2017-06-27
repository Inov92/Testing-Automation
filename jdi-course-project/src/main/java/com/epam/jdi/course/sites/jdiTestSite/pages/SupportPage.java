package com.epam.jdi.course.sites.jdiTestSite.pages;

import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 05.06.2017.
 */
public class SupportPage extends WebPage {

    @JTable(
            root = @FindBy(css = ".uui-table"),
            //row = @FindBy(xpath = ".//li[%s]//div"),
            //column = @FindBy(xpath = ".//li//div[%s]"),
            header = {"Type", "Now", "Plans"})
    public ITable supportTable;

}
