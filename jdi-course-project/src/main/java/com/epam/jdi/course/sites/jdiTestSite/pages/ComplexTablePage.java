package com.epam.jdi.course.sites.jdiTestSite.pages;

import com.epam.jdi.course.entities.Area;
import com.epam.jdi.course.sites.jdiTestSite.customElements.AreaContent;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.TableHeaderTypes.ALL_HEADERS;

/**
 * Created by Ivan on 25.06.2017.
 */
public class ComplexTablePage extends WebPage {
    @JTable(
            root = @FindBy(css = "table.table-delete-body"),
            headerType = ALL_HEADERS,
            colStartIndex = 2,
            header = {"label", "col1", "col2", "col3"})//названия совпадают с AreaContent
    public EntityTable<Area, AreaContent> complexTable = new EntityTable<>(Area.class, AreaContent.class);

    @FindBy(xpath = "//button[.='Reestablish']")
    public Button reestablishButton;

}
