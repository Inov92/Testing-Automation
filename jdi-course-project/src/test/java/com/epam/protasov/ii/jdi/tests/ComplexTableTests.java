package com.epam.protasov.ii.jdi.tests;

import com.epam.jdi.course.dataProviders.TableProvider;
import com.epam.jdi.course.sites.jdiTestSite.customElements.AreaCell;
import com.epam.jdi.course.sites.jdiTestSite.customElements.AreaContent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import com.epam.web.matcher.testng.Assert;
//import org.testng.Assert;


import static com.epam.jdi.course.enums.Preconditions.LOGGED_IN;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.homePage;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.complexTablePage;
import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.Column.inColumn;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

/**
 * Created by Ivan on 25.06.2017.
 */
public class ComplexTableTests extends TestsBase{
    @BeforeMethod
    public void before(Method method) throws IOException {
        homePage.shouldBeOpened();
        isInState(LOGGED_IN);
        complexTablePage.open();
    }

    @Test
    public void changeTableSizeTest() {
        Assert.isTrue(complexTablePage.complexTable.isDisplayed());
        complexTablePage.reestablishButton.click();
        AreaCell a = complexTablePage.complexTable.getRow(1).col2;
        a.select.check();
        Assert.isTrue(complexTablePage.complexTable.columns().count() == 4);
        Assert.isTrue(complexTablePage.complexTable.rows().count() == 8);
    }

    @Test(dataProvider = "ComplexTable",dataProviderClass = TableProvider.class)
    public void contentTest(String complexTableContent){
        complexTablePage.reestablishButton.click();
        Assert.assertEquals(complexTablePage.complexTable.getValue(), complexTableContent);
    }
    @Test
    public void cellCheckSelect(){
        Assert.isTrue(complexTablePage.complexTable.isDisplayed());
        Assert.isFalse(complexTablePage.complexTable::isEmpty);
        complexTablePage.reestablishButton.click();
        AreaContent jsRow = complexTablePage.complexTable.firstRow(r ->
        r.col2.description.getText().contains("JavaScript"));
        jsRow.col2.select.check();
        jsRow.col2.select.isChecked();
//        AreaCell a = complexTablePage.complexTable.getRow(1).col2;
//        a.select.check();
    }

}
