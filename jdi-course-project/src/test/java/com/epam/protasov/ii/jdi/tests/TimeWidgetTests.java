package com.epam.protasov.ii.jdi.tests;

import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.epam.jdi.course.enums.Preconditions.LOGGED_IN;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.datesPage;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.homePage;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

/**
 * Created by Ivan on 05.06.2017.
 */
public class TimeWidgetTests extends TestsBase {
    @BeforeMethod
    public void before(Method method) throws IOException {
        homePage.shouldBeOpened();
        isInState(LOGGED_IN);
        datesPage.open();
        datesPage.timeSection.openTimeWidget();
        datesPage.timeSection.timeWidget.isDisplayed();
    }

    @Test
    public void basicWidgetTest(){
        datesPage.timeSection.timeInputField.setValue("6:00 AM");
        datesPage.timeSection.timeWidget.setIncrementHour(3);
        datesPage.timeSection.timeWidget.setIncrementMinute(3);
        datesPage.timeSection.timeWidget.setChangeMeridiem();
        datesPage.timeSection.timeWidget.setDecrementHour(2);
        datesPage.timeSection.timeWidget.setDecrementMinute(2);
        Assert.areEquals(datesPage.timeSection.timeInputField.getValue(), "7:15 PM",
                "Shown time not equals expected");
        Assert.areEquals(datesPage.timeSection.timeWidget.getSelectedTime(), "7:15 PM",
                "Widget time not equals expected");
        Assert.areEquals(datesPage.timeSection.timeInputField.getValue(),
                datesPage.timeSection.timeWidget.getSelectedTime(),
                "Time in the time textbox is different from selected time");
    }

    @Test
    public void incrementHourTest(){
        datesPage.timeSection.timeInputField.setValue("12:00 AM");
        datesPage.timeSection.timeWidget.setIncrementHour(12);
        Assert.areEquals(datesPage.timeSection.timeInputField.getValue(), "12:00 PM",
                "Shown time not equals expected");
        Assert.areEquals(datesPage.timeSection.timeWidget.getSelectedTime(), "12:00 PM",
                "Widget time not equals expected");

    }
    @Test
    public void decrementHourTest(){
        datesPage.timeSection.timeInputField.setValue("12:00 PM");
        datesPage.timeSection.timeWidget.setDecrementHour(12);
        Assert.areEquals(datesPage.timeSection.timeInputField.getValue(), "12:00 AM",
                "Shown time not equals expected");
        Assert.areEquals(datesPage.timeSection.timeWidget.getSelectedTime(), "12:00 AM",
                "Widget time not equals expected");
    }
    @Test
    public void incrementMinuteTest(){
        datesPage.timeSection.timeInputField.setValue("6:00 PM");
        datesPage.timeSection.timeWidget.setIncrementMinute(4);
        Assert.areEquals(datesPage.timeSection.timeInputField.getValue(), "7:00 PM",
                "Shown time not equals expected");
        Assert.areEquals(datesPage.timeSection.timeWidget.getSelectedTime(), "7:00 PM",
                "Widget time not equals expected");
    }
    @Test
    public void decrementMinuteTest(){
        datesPage.timeSection.timeInputField.setValue("6:00 AM");
        datesPage.timeSection.timeWidget.setDecrementMinute(4);
        Assert.areEquals(datesPage.timeSection.timeInputField.getValue(), "5:00 AM",
                "Shown time not equals expected");
        Assert.areEquals(datesPage.timeSection.timeWidget.getSelectedTime(), "5:00 AM",
                "Widget time not equals expected");
    }
}
