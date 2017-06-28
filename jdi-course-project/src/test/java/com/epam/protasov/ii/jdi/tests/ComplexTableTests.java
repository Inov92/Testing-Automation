package com.epam.protasov.ii.jdi.tests;

import com.epam.jdi.course.dataProviders.TableProvider;
import com.epam.jdi.course.sites.jdiTestSite.customElements.AreaCell;
import com.epam.jdi.course.sites.jdiTestSite.customElements.AreaContent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import com.epam.web.matcher.testng.Assert;
//import org.testng.Assert;


import static com.epam.jdi.course.enums.Preconditions.LOGGED_IN;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.homePage;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.complexTablePage;
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
        Assert.isTrue(complexTablePage.complexTable.isDisplayed());
        complexTablePage.reestablishButton.click();
    }

    @Test
    public void changeTableSizeTest() {
        Assert.isFalse(complexTablePage.complexTable::isEmpty);
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
        complexTablePage.complexTable.getRow(1).Column3.description.isDisplayed();
        Assert.isFalse(complexTablePage.complexTable::isEmpty);
        AreaContent jsRow = complexTablePage.complexTable.firstRow(r ->
        r.Column2.description.getText().contains("JavaScript"));
        jsRow.Column2.select.check();
        Assert.isTrue(jsRow.Column2.select.isChecked());

        //cssCell.col1.select.check();
//        AreaCell a = complexTablePage.complexTable.getRow(1).col2;
//        a.select.check();
    }
    @Test
    public void cellsWithCSSSelect(){
        Assert.isFalse(complexTablePage.complexTable::isEmpty);
        List<AreaContent> cssCells = complexTablePage.complexTable.getRows(r ->
                r.Column1.description.getText().contains("CSS"));
        for(AreaContent content:cssCells){
            content.Column1.select.check();
            Assert.isTrue(content.Column1.select.isChecked());
        }
    }

}
