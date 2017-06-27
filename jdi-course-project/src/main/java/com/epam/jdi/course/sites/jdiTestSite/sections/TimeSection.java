package com.epam.jdi.course.sites.jdiTestSite.sections;

import com.epam.jdi.course.sites.jdiTestSite.customElements.TimeWidget;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 05.06.2017.
 */
public class TimeSection extends WebPage {
    @FindBy (css = ".label-date")
    public Label timeLabel;
    @FindBy (id = "timepicker")
    public TextField timeInputField;
    @FindBy (css = ".add-on.uui-button")
    private Button openTimeWidgetBtn;
    @FindBy (css = ".bootstrap-timepicker-widget")
    public TimeWidget timeWidget;

    public void openTimeWidget(){
        openTimeWidgetBtn.click();
    }
}
