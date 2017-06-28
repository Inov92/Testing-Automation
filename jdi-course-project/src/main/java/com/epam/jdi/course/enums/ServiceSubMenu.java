package com.epam.jdi.course.enums;

/**
 * Created by Ivan on 28.06.2017.
 */
public enum ServiceSubMenu {
    SUPPORT("SUPPORT"), DATES("DATES"), COMPLEX_TABLE("COMPLEX TABLE"), SIMPLE_TABLE("SIMPLE TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"), DIFFERENT_ELEMENTS("DIFFERENT_ELEMENTS");
    private String value;
    ServiceSubMenu(String value){this.value = value;}
    }
