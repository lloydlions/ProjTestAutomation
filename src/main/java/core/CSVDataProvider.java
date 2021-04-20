package core;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.FileHelper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVDataProvider {

    private CSVReader csvReader = null;
    private Object[][] data = null;

    @DataProvider(name = "defaultProvider")
    public static Object[][] readCsv() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(FileHelper.findFile("lloydtest"))); //setfolder location via properties
        List<String[]> csvData=csvReader.readAll();
        csvData.remove(0); //remove header fields
        Object[][] csvDataObject=new Object[csvData.size()][];
        for (int i=0;i<csvData.size();i++) {
            csvDataObject[i]=csvData.get(i);
        }

        return  csvDataObject;
    }
}
