package com.epam.jdi.course.sites.jdiTestSite.sections;

import com.epam.jdi.course.entities.User;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import org.openqa.selenium.support.FindBy;

import java.text.Normalizer;

/**
 * Created by Ivan on 27.05.2017.
 */
public class ContactForm extends Form<User> {
    @FindBy(id = "Name")
    public TextField name;

    @FindBy(id = "LastName")
    public TextField lastName;

    @FindBy(id = "Description")
    public TextField description;


    @FindBy(xpath = "//button[.='Submit']") //Not working?
    //form/div[3]/div[2]/button
    //@FindBy (css = ".div.col-sm-6.text-right>button")
    public Button submit;
}
