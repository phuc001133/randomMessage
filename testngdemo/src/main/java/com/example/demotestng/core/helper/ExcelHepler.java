package com.example.demotestng.core.helper;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHepler{

    private static XSSFWorkbook _workBook;
    private static XSSFSheet _sheet;
    private static XSSFRow _row;
    private static XSSFCell _cell;

    public static String getCellData(int rowNum, int colNum){
        try{
            _cell = _sheet.getRow(rowNum).getCell(colNum);
            _cell.getCellType();
            if(_cell.getCellType() == CellType.ERROR || _cell.getCellType() == CellType._NONE ){
                return "";
            }
            String cellData = _cell.getStringCellValue();
            return cellData;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }

    public static Object[][] getDataFromExcelFile(String fileName, String sheetName) throws IOException {
        Object[][] data = null;
        try{
            FileInputStream excelFile = new FileInputStream(fileName);
            _workBook = new XSSFWorkbook(excelFile);
            _sheet = _workBook.getSheet(sheetName);
            _row = _sheet.getRow(0);
            int dataRowNum = _sheet.getPhysicalNumberOfRows() - 1;
            int dataColNum = _row.getLastCellNum();

            data = new Object[dataRowNum][dataColNum];
            for(int i = 0; i < dataRowNum; i++ ){
                XSSFRow row = _sheet.getRow(i+1);
                for(int j = 0; j < dataColNum; j++){
                    if(row == null){
                        data[i][j] = "";
                    }
                    else{
                        data[i][j] = getCellData(i+1,j);
                    }
                }
            }
            return data;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }
}
