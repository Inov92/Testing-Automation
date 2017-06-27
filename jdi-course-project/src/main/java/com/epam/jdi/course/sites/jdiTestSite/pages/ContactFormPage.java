package com.epam.jdi.course.sites.jdiTestSite.pages;

import com.epam.jdi.course.sites.jdiTestSite.sections.ContactForm;
import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Ivan on 26.05.2017.
 */
public class ContactFormPage extends WebPage {
    @FindBy (css = ".form")
    public ContactForm contactForm;

    @FindBy (className = "epam-logo")
    public Image logo;

    @FindBy(css= ".results")
    public List<WebElement> resultSection;
}
