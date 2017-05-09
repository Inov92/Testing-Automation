import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Класс предназначен для хранения данных отдельно от тестов
 */
public class DataProviders {
    TestSettings settings = new TestSettings();
    @DataProvider(name = "dataFromMethod") //Название дата провайдера изменено, чтобы различать поставщика данных
    public Object[][] getUsers(){
        return new Object[][]{{"Иван", "311292"}}; //Лучше использовать правдоподобные данные
    }
    @DataProvider(name = "dataFromCsv")
    public Object[][] getCsvFile(){
        return loadDataFromCsv(settings.getCsvPath());
    }

    private Object[][] loadDataFromCsv(String path){
        String name = "";
        String pass = "";
        Object[][] data = new Object[1][2];
        int i = 0;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        //TO DO Сдеать считываний файлонезависимым
        //Сейчас записываетя только первая строчка файла csv
        try {

            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] login = line.split(cvsSplitBy);
                data[0] = new Object[]{login[0], login[1]};
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
