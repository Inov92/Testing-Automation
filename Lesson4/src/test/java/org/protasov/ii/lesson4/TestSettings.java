package org.protasov.ii.lesson4;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestSettings {

    private String driverName; // имя WebDriver
    private String driverPath; // путь к WebDriver
    private String csvPath; //путь к .csv файлу, содержащему логин и пароль

    public TestSettings(){

        Properties p = readSettings(this);
        driverName = p.getProperty("driverName");
        driverPath = p.getProperty("driverPath");
        csvPath =  p.getProperty("loginPath");

    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getCsvPath() {
        return csvPath;
    }

    //метод чтения config.properties файла
    static Properties readSettings(TestSettings settings){
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = settings.getClass().getResourceAsStream("config.properties");
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;

    }




}
