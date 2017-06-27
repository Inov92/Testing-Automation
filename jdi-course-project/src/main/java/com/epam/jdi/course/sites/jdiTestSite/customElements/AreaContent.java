package com.epam.jdi.course.sites.jdiTestSite.customElements;

import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ivan on 25.06.2017.
 */
public class AreaContent extends Section {
    @FindBy(css = ".title-col>span")
    public Link label;
    public AreaCell col1;
    public AreaCell col2;
    public AreaCell col3;

}
