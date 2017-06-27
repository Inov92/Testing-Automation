package com.epam.jdi.course.entities;

/**
 * Created by Ivan on 24.05.2017.
 */
public class User {

    public String loginField;
    public String password;
    public String name;
    public String lastName;
    public String description;

    public User(){
        loginField = "epam";
        password = "1234";
        name = "Ivan";
        lastName = "Protasov";
        description = "I'm Junior QA Engineer";
    }

    public User(String login, String password){
        loginField = login;
        this.password = password;
        name = "Ivan";
        lastName = "Protasov";
        description = "I'm Junior QA Engineer";

    }
}
