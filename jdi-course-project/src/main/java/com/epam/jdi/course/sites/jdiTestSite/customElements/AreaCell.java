package com.epam.jdi.course.sites.jdiTestSite.customElements;

import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 25.06.2017.
 */
public class AreaCell extends Section {
    @FindBy(css = ".checkbox")
    public CheckBox select = new CheckBox() {
        @Override
        protected boolean isCheckedAction() {
            return getWebElement().findElement(By.tagName("input")).getAttribute("checked") != null;
        }
    };
    @FindBy(css = ".seeMore")
    public Link seeMore;
    @FindBy(css = "tr p:not(.checkbox)")
    public Text description;

}
