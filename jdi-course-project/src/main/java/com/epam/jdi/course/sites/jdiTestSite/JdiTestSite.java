package com.epam.jdi.course.sites.jdiTestSite;

import com.epam.jdi.course.entities.User;
import com.epam.jdi.course.enums.HeaderMenu;
import com.epam.jdi.course.sites.jdiTestSite.pages.*;
import com.epam.jdi.course.sites.jdiTestSite.sections.Profile;
import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 24.05.2017.
 */
@JSite(domain = "https://epam.github.io/JDI")
public class JdiTestSite extends WebSite {
    @JPage(url = "/index.htm", title = "Index Page")
    public static HomePage homePage;

    @JPage(url = "/page1.htm", title = "Contact Form")
    public static ContactFormPage contactPage;

    @JPage(url = "/page4.htm", title = "Dates")
    public static DatesPage datesPage;

    @JPage (url = "/page6.htm", title = "Simple Table")
    public static SimpleTablePage simpleTablePage;

    @JPage (url = "/page3.htm", title = "Support")
    public static SupportPage supportPage;

    @JPage (url = "/page5.htm", title = "Complex Page")
    public static ComplexTablePage complexTablePage;

    @FindBy (css = ".uui-profile")
    public static Profile profile;

    @FindBy(css = ".m-l8>li>a")
    public static Menu<HeaderMenu> headerMenu;

    @FindBy(id = "epam_logo")
    public static Image logo;



}
