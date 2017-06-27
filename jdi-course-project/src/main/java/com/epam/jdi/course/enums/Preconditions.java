package com.epam.jdi.course.enums;

import com.epam.commons.linqinterfaces.JAction;
import com.epam.jdi.course.sites.jdiTestSite.JdiTestSite;
import com.epam.jdi.uitests.core.preconditions.IPreconditions;
import com.google.common.base.Supplier;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.alwaysMoveToCondition;
import static com.epam.jdi.course.sites.jdiTestSite.JdiTestSite.*;
/**
 * Created by Ivan on 29.05.2017.
 */
public enum Preconditions implements IPreconditions {
    LOGGED_IN(() -> homePage.isLoggedIn(), () -> homePage.login()),
    LOGGED_OUT(() -> homePage.isLoggedOut(), () -> homePage.logout());

    public Supplier<Boolean> checkAction;
    public JAction moveToAction;

    Preconditions(Supplier<Boolean> checkAction, JAction moveToAction) {
        this.checkAction = checkAction;
        this.moveToAction = moveToAction;
        alwaysMoveToCondition = false;
    }


    public Boolean checkAction() { return checkAction.get();}

    public void moveToAction() { moveToAction.invoke(); }
}
