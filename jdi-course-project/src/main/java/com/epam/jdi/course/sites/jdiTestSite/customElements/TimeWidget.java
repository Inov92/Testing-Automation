package com.epam.jdi.course.sites.jdiTestSite.customElements;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 05.06.2017.
 */
public class TimeWidget extends Section{
    @FindBy (css = ".add-on.uui-button")
    public Button openTimeWidget;
    @FindBy(className = "bootstrap-timepicker-hour")
    public TextField hourField;
    @FindBy(className = "bootstrap-timepicker-minute")
    public TextField minuteField;
    @FindBy(className = "bootstrap-timepicker-meridian")
    public TextField meridiemField;
    @FindBy(xpath = "//a[@data-action='incrementHour']/i")
    private Button incrementHour;
    @FindBy(xpath = "//a[@data-action='incrementMinute']/i")
    private Button incrementMinute;
    @FindBy(className = "meridian-column")
    private Button changeMeridiem;
    @FindBy(xpath = "//a[@data-action='decrementHour']/i")
    private Button decrementHour;
    @FindBy(xpath = "//a[@data-action='decrementMinute']/i")
    private Button decrementMinute;

    public void setIncrementHour(int nTimes){
        for (int i = 0; i < nTimes; i++) {
            incrementHour.click();
        }
    }
    public void setIncrementMinute(int nTimes){
        for (int i = 0; i < nTimes; i++) {
            incrementMinute.click();
        }
    }
    public void setChangeMeridiem(){
        changeMeridiem.click();
    }
    public  void setDecrementHour(int nTimes){
        for (int i = 0; i < nTimes; i++) {
            decrementHour.click();
        }
    }
    public  void setDecrementMinute(int nTimes){
        for (int i = 0; i < nTimes; i++) {
            decrementMinute.click();
        }
    }

    public String getSelectedTime(){
        return hourField.getValue() + ":" + minuteField.getValue() + " " + meridiemField.getValue();
    }

}
