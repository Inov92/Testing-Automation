package com.epam.jdi.course.entities;

/**
 * Created by Ivan on 25.06.2017.
 */
public class Area {
    public String technology;
    public String column1;
    public String column2;
    public String column3;
    public Area(){
        technology ="";
        column1 = "";
        column2 = "";
        column3 = "";
    }
    public Area(String tech, String col1, String col2, String col3){
        technology = tech;
        column1 = col1;
        column2 = col2;
        column3 = col3;
    }
    @Override
    public String toString() {
        return String.format("Technology: %s; Column1: %s; Column2: %s; Column3: %s;",
                technology, column1, column2, column3);
    }
}
