package com.epam.jdi.course.sites.jdiTestSite.pages;

import com.epam.jdi.course.sites.jdiTestSite.sections.TimeSection;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 28.05.2017.
 */
public class DatesPage extends WebPage {
    @FindBy (xpath = "//div[3]/div[2]/div[1]")
    public TimeSection timeSection;

}
