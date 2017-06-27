package com.epam.jdi.course.dataProviders;

import org.testng.annotations.DataProvider;
import com.epam.jdi.course.entities.User;


/**
 * Created by Ivan on 24.05.2017.
 */
public class UsersProvider {


    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][]{
                { new User() }
        };
    }
}
