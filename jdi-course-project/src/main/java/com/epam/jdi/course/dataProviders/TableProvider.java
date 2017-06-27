package com.epam.jdi.course.dataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by Ivan on 24.06.2017.
 */
public class TableProvider {
    @DataProvider(name = "SupportTable")
    public static Object[][] supportTable() {
        return new Object[][]{
                { "||X||Type|Now|Plans||\n" +
                        "||1||Drivers|Selenium, Custom|JavaScript, Appium, WinAPI, Sikuli||\n" +
                        "||2||Test Runner|TestNG, JUnit, Custom|MSTest, NUnit, Epam||\n" +
                        "||3||Asserter|TestNG, JUnit, Custom|MSTest, NUnit, Epam||\n" +
                        "||4||Logger|Log4J, TestNG log, Custom|Epam, XML/Json logging, Hyper logging||\n" +
                        "||5||Reporter|Jenkins, Allure, Custom|EPAM Report portal, Serenity, TimCity, Hudson||\n" +
                        "||6||BDD/DSL|Custom|Cucumber, Jbehave, Thucydides, SpecFlow||" }
        };
    }
    @DataProvider(name = "ComplexTable")
    public static Object[][] complexTable() {
        return new Object[][]{
                { "||X||label|col1|col2|col3||\n" +
                        "||1||Microsoft Technologies|Select\n" +
                        "See More\n" +
                        ".NET Technologies|Select\n" +
                        "See More\n" +
                        "Internet Technologies|Select\n" +
                        "See More\n" +
                        "Programming Languages||\n" +
                        "||2||Mobile|Select\n" +
                        "See More\n" +
                        "HTML5/CSS3|Select\n" +
                        "See More\n" +
                        "JQuery Mobile|Select\n" +
                        "See More\n" +
                        "JQuery Mobile||\n" +
                        "||3||UXD|Select\n" +
                        "See More\n" +
                        "(X)CSS Development|Select\n" +
                        "See More\n" +
                        "Grunt (The JavaScript Task Runner)|Select\n" +
                        "See More\n" +
                        "Less CSS||\n" +
                        "||4||Version Control Systems|Select\n" +
                        "See More\n" +
                        "CVS|Select\n" +
                        "See More\n" +
                        "TortoiseSVN|Select\n" +
                        "See More\n" +
                        "Git||\n" +
                        "||5||JavaScript Components and Frameworks|Select\n" +
                        "See More\n" +
                        "Backbone marionette js|Select\n" +
                        "See More\n" +
                        "Bootstrap|Select\n" +
                        "See More\n" +
                        "RequireJS||\n" +
                        "||6||Software Construction|Select\n" +
                        "See More\n" +
                        "Internet Technologies|Select\n" +
                        "See More\n" +
                        "JavaScript Components and Frameworks|Select\n" +
                        "See More\n" +
                        "Backend||\n" +
                        "||7||Life Sciences|Select\n" +
                        "See More\n" +
                        "Biology|Select\n" +
                        "See More\n" +
                        "Chemistry|Select\n" +
                        "See More\n" +
                        "Medicine||\n" +
                        "||8||Content management|Select\n" +
                        "See More\n" +
                        "Drupal|Select\n" +
                        "See More\n" +
                        "Adobe Day CRX|Select\n" +
                        "See More\n" +
                        "Sharepoint||" }
        };
    }
}
