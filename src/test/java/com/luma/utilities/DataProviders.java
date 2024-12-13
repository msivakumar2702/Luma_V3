package com.luma.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData1")
    public String[][] getData1() throws IOException {
        String path = System.getProperty("user.dir") + "/testData/CustomerDetails.xlsx";

       // ExcelUtils xlutil = new ExcelUtils();
        ExcelUtils.setFilePath(path); // Set the file path dynamically

        int totalRows = ExcelUtils.getRowCount("Customer Data");
        int totalCols = ExcelUtils.getCellCount("Customer Data", 1);

        String[][] loginData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = ExcelUtils.getCellData("Customer Data", i, j);
            }
        }

        return loginData;
    }

    // DataProvider 2
    @DataProvider(name = "LoginData2")
    public String[][] getData2() throws IOException {
        String path = System.getProperty("user.dir") + "/testData/CustomerDetails1.xlsx";

       // ExcelUtils xlutil = new ExcelUtils();
        ExcelUtils.setFilePath(path); // Set the file path dynamically

        int totalRows = ExcelUtils.getRowCount("Sheet1");
        int totalCols = ExcelUtils.getCellCount("Sheet1", 1);

        String[][] loginData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = ExcelUtils.getCellData("Sheet1", i, j);
            }
        }

        return loginData;
    }

    // Additional DataProviders can be added here
}
