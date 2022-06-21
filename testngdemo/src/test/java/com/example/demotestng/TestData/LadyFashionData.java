package com.example.demotestng.TestData;

import com.example.demotestng.core.helper.ExcelHepler;
import com.example.demotestng.core.helper.JSONHelper;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LadyFashionData {

    @DataProvider
    public static Object[][] ProductData(){
        return JSONHelper.ReadJsonFromFile("src/test/java/com/example/demotestng/resource/product.json");
    }

    @DataProvider
    public static Object[][] TestChoi(){
        return JSONHelper.ReadJsonFromFile("src/test/java/com/example/demotestng/resource/testing.json");
    }
    @DataProvider
    public static Object[][] ProductDataFromExcel() throws IOException {
        return ExcelHepler.getDataFromExcelFile("src/test/java/com/example/demotestng/resource/Book1.xlsx", "Sheet1");
    }

}
