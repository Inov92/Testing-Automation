package com.epam.protasov.ii.jdi.tests;

import com.epam.commons.map.MapArray;
import com.epam.jdi.course.dataProviders.TableProvider;
//import org.testng.Assert;
import com.epam.jdi.course.sites.jdiTestSite.JdiTestSite;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.Column;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ICell;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import  com.epam.web.matcher.testng.Assert;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.epam.jdi.course.enums.Preconditions.LOGGED_IN;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.homePage;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.supportPage;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

/**
 * Created by Ivan on 05.06.2017.
 */
public class SupportTableTests extends TestsBase {
    @BeforeMethod
    public void before(Method method) throws IOException {
        homePage.shouldBeOpened();
        isInState(LOGGED_IN);
        supportPage.shouldBeOpened();
    }

    @Test(dataProvider = "SupportTable", dataProviderClass = TableProvider.class)
    public void supportTableInfo(String tableContent){
        Assert.isFalse(supportPage.supportTable::isEmpty);
        Assert.areEquals(supportPage.supportTable.rows().count(), 6);
        Assert.areEquals(supportPage.supportTable.columns().count(), 3);
        Assert.areEquals(supportPage.supportTable.getValue(), tableContent);

    }
    @Test
    public void contentTest(){
        MapArray<String, ICell> loggerRow = supportPage.supportTable.rows(
                "Type=Logger")
                .first().value;
        Assert.areEquals(loggerRow.get("Type").getText(), "Logger");
        Assert.areEquals(loggerRow.get("Now").getText(), "Log4J, TestNG log, Custom");
        Assert.areEquals(loggerRow.get("Plans").getText(), "Epam, XML/Json logging, Hyper logging");

    }

}
