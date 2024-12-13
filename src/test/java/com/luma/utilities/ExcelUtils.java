package com.luma.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;

public class ExcelUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static String path;


	

	// Method to set the file path
    public static void setFilePath(String filePath) {
        path = filePath;
    }

    // Get the row count for a sheet
    public static int getRowCount(String sheetName) {
        int rowCount = 0;
        try {
            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);
            sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                rowCount = sheet.getLastRowNum();
            }
            workbook.close();
            fi.close();
        } catch (IOException e) {
            System.err.println("Error reading row count: " + e.getMessage());
        }
        return rowCount;
    }

    // Get the cell count for a row
    public static int getCellCount(String sheetName, int rowNum) {
        int cellCount = 0;
        try {
            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);
            sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                row = sheet.getRow(rowNum);
                if (row != null) {
                    cellCount = row.getLastCellNum();
                }
            }
            workbook.close();
            fi.close();
        } catch (IOException e) {
            System.err.println("Error reading cell count: " + e.getMessage());
        }
        return cellCount;
    }

    // Get cell data
    public static String getCellData(String sheetName, int rowNum, int colNum) {
        String data = "";
        try {
            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);
            sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                row = sheet.getRow(rowNum);
                if (row != null) {
                    cell = row.getCell(colNum);
                    DataFormatter formatter = new DataFormatter();
                    data = formatter.formatCellValue(cell);
                }
            }
            workbook.close();
            fi.close();
        } catch (IOException e) {
            System.err.println("Error reading cell data: " + e.getMessage());
        }
        return data;
    }

    // Write customer data to the Excel file
    public static void writeCustomerDataToExcel(String fname, String lname, String email, String password) {
        if (path == null || path.isEmpty()) {
            System.err.println("File path is not set. Please initialize the file path using setFilePath().");
            return;
        }

        File file = new File(path);

        try {
            if (file.exists()) {
                fi = new FileInputStream(file);
                workbook = new XSSFWorkbook(fi);
                sheet = workbook.getSheet("Customer Data");

                if (sheet == null) {
                    sheet = workbook.createSheet("Customer Data");
                }
                fi.close();
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Customer Data");

                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("First Name");
                headerRow.createCell(1).setCellValue("Last Name");
                headerRow.createCell(2).setCellValue("Email Address");
                headerRow.createCell(3).setCellValue("Password");
            }

            int lastRowNum = sheet.getLastRowNum();
            Row dataRow = sheet.createRow(lastRowNum + 1);
            dataRow.createCell(0).setCellValue(fname);
            dataRow.createCell(1).setCellValue(lname);
            dataRow.createCell(2).setCellValue(email);
            dataRow.createCell(3).setCellValue(password);

            for (int i = 0; i < 4; i++) {
                sheet.autoSizeColumn(i);
            }

            fo = new FileOutputStream(path);
            workbook.write(fo);
            workbook.close();
            fo.close();

            System.out.println("Customer data written to Excel file successfully.");

        } catch (IOException e) {
            System.err.println("Error writing data to Excel file: " + e.getMessage());
        }
    }
}
